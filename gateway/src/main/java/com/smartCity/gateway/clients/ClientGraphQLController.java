package com.smartCity.gateway.clients;

import com.smartCity.gateway.entities.agriculture.Farm;
import com.smartCity.gateway.entities.agriculture.Operation;
import com.smartCity.gateway.entities.agriculture.Produce;
import com.smartCity.gateway.services.AgricultureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/agriculture")
public class ClientGraphQLController {
    @Autowired
    AgricultureService agricultureService;

    @PostMapping("/addProduce")
    public Mono<ResponseEntity<Produce>> addProduce(@RequestBody Produce request) {

        return agricultureService.addProduce(
                request.getName(),
                request.getQuantityPesticides(),
                request.getQuotaMaxPesticides()
        ).map(produce -> ResponseEntity.ok(produce));
    }
    @GetMapping("getProduce/{id}")
    public Mono<ResponseEntity<Produce>> getProduceById(@PathVariable Integer id) {
        return agricultureService.getProduceById(id).map(produce -> ResponseEntity.ok(produce));
    }
    @GetMapping("assginProduceToFarm/{idFarm}/{idProduce}")
    public Mono<ResponseEntity<Farm>> assginProduceToFarm(@PathVariable Integer idFarm, @PathVariable Integer idProduce) {
        return agricultureService.assignProduceToFarm(idFarm,idProduce).map(farm -> ResponseEntity.ok(farm));
    }
    @GetMapping("assginOperationToProduce/{idOperation}/{idProduce}")
    public Mono<ResponseEntity<Operation>> assginOperationToProduce(@PathVariable Integer idOperation, @PathVariable Integer idProduce) {
        return agricultureService.assignProduceToOperationPlan(idProduce,idOperation).map(operation -> ResponseEntity.ok(operation));
    }
    @GetMapping("getProducesByFarm")
    public Mono<ResponseEntity<List<Produce>>> getproducesByFarm() {
        return agricultureService.getAllProduces().map(produce -> ResponseEntity.ok(produce));
    }



}
