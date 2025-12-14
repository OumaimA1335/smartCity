package com.smartCity.gateway.services;

import com.smartCity.gateway.clients.ClientAgricultureGraphQL;
import com.smartCity.gateway.clients.ClientMobilityRest;
import com.smartCity.gateway.clients.ClientFinesSoap;
import com.smartCity.gateway.clients.ClientWeatherGrpc;
import com.smartCity.gateway.entities.agriculture.Operation;
import com.smartCity.gateway.entities.agriculture.Produce;
import com.smartCity.gateway.entities.citizen.GetCitizenFinesResponse;
import com.smartCity.gateway.entities.mobility.Schedules;
import com.smartCity.gateway.entities.orchestrator.OrchestratorOverView;
import org.apache.maven.lifecycle.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class OrchestrateurService {

    @Autowired
    ClientMobilityRest clientMobility;
    @Autowired
    ClientFinesSoap clientSoap;
    @Autowired
    ClientAgricultureGraphQL clientGraphQL;
    @Autowired
    ClientWeatherGrpc clientWeatherGrpc;

    public Mono<Map<String, Object>> operation(OrchestratorOverView data) {

        return clientWeatherGrpc
                .getWeatherByCityAndDate(data.getCity(), data.getDate())
                .map(this::extractWeather)
                .flatMap(weather -> {

                    // =========================
                    // 1️ Initialisation résultat
                    // =========================
                    Map<String, Object> result = new LinkedHashMap<>();
                    result.put("humidity", weather.get("humidity"));
                    result.put("windSpeed", weather.get("windSpeed"));
                    result.put("message 1", "⚠ Conditions  favorables pour l'agriculture");
                    // =========================
                    // 2️ Vérification météo
                    // =========================
                    if (!isWeatherGoodForAgriculture(weather)) {
                        result.put("message 2", "⚠ Conditions non favorables pour l'agriculture");
                        return Mono.just(result);
                    }

                    // =========================
                    // 3️ Appels GraphQL
                    // =========================
                    Mono<ResponseEntity<Produce>> produceMono =
                            clientGraphQL.getProduceByName(data.getProduceName());

                    Mono<ResponseEntity<Operation>> operationMono =
                            clientGraphQL.getOperationByOperationType(data.getOperationType());

                    // =========================
                    // 4️ Assignation Operation → Produce
                    // =========================
                    return Mono.zip(produceMono, operationMono)
                            .flatMap(tuple -> {

                                Long idProduce = tuple.getT1().getBody().getId();
                                Long idOperation = tuple.getT2().getBody().getId();

                                return clientGraphQL.assginOperationToProduce(idOperation, idProduce)
                                        .then(

                                                // =========================
                                                // 5️ Appel SOAP (amendes)
                                                // =========================
                                                Mono.fromCallable(() ->
                                                        clientSoap.getCitizenFines(data.getIdCitizen())
                                                ).flatMap(response -> {
                                                    result.put("message 3",
                                                            " → opération assignée: "+data.getOperationType());
                                                    Mono.just(result);
                                                    GetCitizenFinesResponse body =
                                                            (GetCitizenFinesResponse) response.getBody();
                                                    // Amendes trouvées → pas de schedule
                                                    if (((GetCitizenFinesResponse) response.getBody()).getReturn()!= null) {

                                                        result.put("message 4",
                                                                "Amendes trouvées → L'agriculture a des amendes donc il ne peut transporter ses produits");

                                                        return Mono.just(result);
                                                    }

                                                    // =========================
                                                    // 6️ Ajout schedule mobilité
                                                    // =========================
                                                    Schedules schedule = new Schedules(
                                                            data.getDepartureTime(),
                                                            data.getArrivalTime(),
                                                            data.getStationDepart(),
                                                            data.getStationArrivee(),
                                                            data.getTransportLineId()
                                                    );

                                                    return clientMobility.addSchedule(schedule)
                                                            .thenReturn(
                                                                    resultWithMessage(
                                                                            result,
                                                                            "✅ Operation assignée et schedule ajouté -> l'agriculteur n'a pas des factures non payée , il peut transporter son culture"
                                                                    )
                                                            );
                                                })
                                        );
                            });
                });
    }




    // Méthode pour transformer la réponse en Map simple
    private Map<String, Double> extractWeather(ResponseEntity<Map<String, Object>> response) {
        Map<String, Object> weather = response.getBody();

        double humidity = weather.get("humidity") != null
                ? Double.parseDouble(weather.get("humidity").toString())
                : 0.0;

        double windSpeed = weather.get("windSpeed") != null
                ? Double.parseDouble(weather.get("windSpeed").toString())
                : 0.0;

        return Map.of("humidity", humidity, "windSpeed", windSpeed);
    }

    // Méthode pour vérifier si les conditions sont bonnes
    private boolean isWeatherGoodForAgriculture(Map<String, Double> weather) {
        double humidity = weather.get("humidity");
        double windSpeed = weather.get("windSpeed");
        return humidity > 50 && windSpeed < 15;  // exemple de conditions
    }
    private Map<String, Object> resultWithMessage(Map<String, Object> result, String message) {
        result.put("message", message);
        return result;
    }

}
