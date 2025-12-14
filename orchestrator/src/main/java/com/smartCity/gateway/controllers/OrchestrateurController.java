package com.smartCity.gateway.controllers;

import com.smartCity.gateway.entities.orchestrator.OrchestratorOverView;
import com.smartCity.gateway.services.OrchestrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/orchestrateur")
public class OrchestrateurController {

    @Autowired
    OrchestrateurService orchestrateurService;

    @PostMapping("/workflow")
    public Mono<ResponseEntity<Map<String, Object>>> workflow(
            @RequestBody OrchestratorOverView data) {
        return orchestrateurService.operation(data)
                .map(result -> ResponseEntity.ok(result));
    }


}
