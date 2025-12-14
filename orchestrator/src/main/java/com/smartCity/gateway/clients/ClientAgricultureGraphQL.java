package com.smartCity.gateway.clients;

import com.smartCity.gateway.entities.agriculture.Farm;
import com.smartCity.gateway.entities.agriculture.Operation;
import com.smartCity.gateway.entities.agriculture.Produce;
import com.smartCity.gateway.services.AgricultureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class ClientAgricultureGraphQL {
    @Autowired
    AgricultureService agricultureService;


    public Mono<ResponseEntity<Produce>> addProduce( Produce request) {

        return agricultureService.addProduce(
                request.getName(),
                request.getQuantityPesticides(),
                request.getQuotaMaxPesticides()
        ).map(produce -> ResponseEntity.ok(produce));
    }

    public Mono<ResponseEntity<Produce>> getProduceById( Integer id) {
        return agricultureService.getProduceById(id).map(produce -> ResponseEntity.ok(produce));
    }

    public Mono<ResponseEntity<Farm>> assginProduceToFarm( Integer idFarm,  Integer idProduce) {
        return agricultureService.assignProduceToFarm(idFarm,idProduce).map(farm -> ResponseEntity.ok(farm));
    }

    public Mono<ResponseEntity<Operation>> assginOperationToProduce( Long idOperation, Long idProduce) {
        return agricultureService.assignProduceToOperationPlan(idProduce,idOperation).map(operation -> ResponseEntity.ok(operation));
    }
    public Mono<ResponseEntity<List<Produce>>> getproducesByFarm() {
        return agricultureService.getAllProduces().map(produce -> ResponseEntity.ok(produce));
    }

    public Mono<ResponseEntity<Produce>> getProduceByName(String name) {
        return agricultureService.getProduceByName(name).map(produce -> ResponseEntity.ok(produce));
    }

    public Mono<ResponseEntity<Operation>> getOperationByOperationType(String operationType) {
        return agricultureService.getOperationPlanByOperationType(operationType).map(operation -> ResponseEntity.ok(operation));
    }





}
