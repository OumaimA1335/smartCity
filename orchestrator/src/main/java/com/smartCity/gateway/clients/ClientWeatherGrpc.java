package com.smartCity.gateway.clients;

import com.smartCity.weather.services.weather.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static reactor.netty.http.HttpConnectionLiveness.log;

@Component
public class ClientWeatherGrpc {
    
    private final ManagedChannel channel;
    //crée stub
    WeatherServiceGrpc.WeatherServiceBlockingStub stub;
    public ClientWeatherGrpc() {
        this.channel = ManagedChannelBuilder.forAddress("localhost", 9090)
            .usePlaintext()  // Pour développement seulement
            .build();
        stub =WeatherServiceGrpc.newBlockingStub(channel);
    }
    /**
     * Méthode GET pour récupérer la météo par ID
     */

    public Mono<ResponseEntity<Map<String, Object>>> getWeatherById( Integer id) {
        return Mono.fromCallable(() -> {
            try {

                // Construire la requête
                WeatherRequest request = WeatherRequest.newBuilder()
                        .setId(id)
                        .build();

                // Appeler le service gRPC (appel bloquant)
                WeatherResponse response = stub.getWeather(request);

                // Convertir la réponse en Map
                Map<String, Object> result = convertToMap(response);
                result.put("status", "success");
                result.put("source", "gRPC-WeatherService");
                result.put("timestamp", LocalDateTime.now());

                log.info("Réponse gRPC reçue pour id: {}", id);
                return ResponseEntity.ok(result);

            } catch (StatusRuntimeException e) {
                log.error("Erreur gRPC pour id {}: {}", id, e.getStatus());

                Map<String, Object> error = new HashMap<>();
                error.put("error", "GRPC_SERVICE_ERROR");
                error.put("message", e.getStatus().getDescription());
                error.put("code", e.getStatus().getCode().name());
                error.put("weatherId", id);
                error.put("timestamp", LocalDateTime.now());

                return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(error);
            }
        }).subscribeOn(Schedulers.boundedElastic());
    }


    public Mono<ResponseEntity<Map<String, Object>>>getWeatherByCityAndDate( String city, String date) {
        return Mono.fromCallable(() -> {
            try {

                // Construire la requête
                WeatherCityAndDateRequest request = WeatherCityAndDateRequest.newBuilder()
                        .setCity(city)
                        .setDate(date)
                        .build();

                // Appeler le service gRPC (appel bloquant)
                WeatherResponse response = stub.getWeatherByCityAndDate(request);
                // Convertir la réponse en Map
                Map<String, Object> result = convertToMap(response);
                result.put("status", "success");
                result.put("source", "gRPC-WeatherService");
                result.put("timestamp", LocalDateTime.now());
                log.info("Réponse gRPC reçue pour city: {}", city);
                return ResponseEntity.ok(result);

            } catch (StatusRuntimeException e) {
                log.error("Erreur gRPC pour city {}: {}", city, e.getStatus());

                Map<String, Object> error = new HashMap<>();
                error.put("error", "GRPC_SERVICE_ERROR");
                error.put("message", e.getStatus().getDescription());
                error.put("code", e.getStatus().getCode().name());
                error.put("timestamp", LocalDateTime.now());

                return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(error);
            }
        }).subscribeOn(Schedulers.boundedElastic());
    }




    private Map<String, Object> convertToMap(WeatherResponse response) {
        Map<String, Object> result = new HashMap<>();

        result.put("id", response.getId());

        // Convertir Location
        if (response.hasLocation()) {
            com.smartCity.weather.services.weather.Location   location = response.getLocation();
            Map<String, Object> locationMap = new HashMap<>();
            locationMap.put("id", location.getId());
            locationMap.put("city", location.getCity());
            locationMap.put("country", location.getCountry());
            locationMap.put("latitude", location.getLatitude());
            locationMap.put("longitude", location.getLongitude());
            result.put("location", locationMap);
        }

        result.put("temperature", response.getTemperature());
        result.put("humidity", response.getHumidity());
        result.put("pressure", response.getPressure());
        result.put("windSpeed", response.getWindSpeed());
        result.put("windDirection", response.getWindDirection());
        result.put("date", response.getDate());

        return result;
    }



}