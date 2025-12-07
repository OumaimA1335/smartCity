package com.smartCity.gateway.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartCity.gateway.config.GraphqlClientConfig;
import com.smartCity.gateway.entities.agriculture.Farm;
import com.smartCity.gateway.entities.agriculture.Operation;
import com.smartCity.gateway.entities.agriculture.Produce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AgricultureService {

    @Autowired
    GraphqlClientConfig client;
    private final ObjectMapper objectMapper;
    public AgricultureService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    // Mutation: addProduce
    public Mono<Produce> addProduce(String name, int quantityPesticides, int quotaMaxPesticides) {
        String query = """
            mutation AddProduce($name: String!, $quantityPesticides: Int!, $quotaMaxPesticides: Int!) {
                addProduce(name: $name, quantityPesticides: $quantityPesticides, quotaMaxPesticides: $quotaMaxPesticides) {
                    id
                    name
                    quantityPesticides
                    quotaMaxPesticides
                }
            }
            """;

        Map<String, Object> variables = new HashMap<>();
        variables.put("name", name);
        variables.put("quantityPesticides", quantityPesticides);
        variables.put("quotaMaxPesticides", quotaMaxPesticides);

        return sendGraphQLRequest(query, variables)
                .map(response -> {
                    Map<String, Object> data = (Map<String, Object>) response.get("data");
                    Map<String, Object> addProduceData = (Map<String, Object>) data.get("addProduce");
                    return objectMapper.convertValue(addProduceData, Produce.class);
                });
    }
    public Mono<Farm> assignProduceToFarm(Integer farmId, Integer produceId) {

        String query = """
        mutation AssignProduceToFarm($farmId: ID!, $produceId: ID!) {
          assignProduceToFarm(farmId: $farmId, produceId: $produceId) {
            id
            name
            location
          }
        }
        """;

        Map<String, Object> variables = new HashMap<>();
        variables.put("farmId", farmId);
        variables.put("produceId", produceId);

        return sendGraphQLRequest(query, variables)
                .map(response -> {
                    Map<String, Object> data = (Map<String, Object>) response.get("data");
                    Map<String, Object> assignData = (Map<String, Object>) data.get("assignProduceToFarm");
                    return objectMapper.convertValue(assignData, Farm.class);
                });
    }

    public Mono<Operation> assignProduceToOperationPlan(Integer produceId, Integer planId) {

        String query = """
        mutation AssignProduceToOperationPlan($produceId: ID!, $planId: ID!) {
          assignProduceToOperationPlan(produceId: $produceId, planId: $planId) {
            id
            operationType
            plannedDate
          }
        }
        """;

        Map<String, Object> variables = new HashMap<>();
        variables.put("produceId", produceId);
        variables.put("planId", planId);

        return sendGraphQLRequest(query, variables)
                .map(response -> {
                    Map<String, Object> data = (Map<String, Object>) response.get("data");
                    Map<String, Object> assignData = (Map<String, Object>) data.get("assignProduceToOperationPlan");
                    // Convertir en DTO
                    return objectMapper.convertValue(assignData, Operation.class);
                });
    }



    public Mono<Produce> getProduceById(Integer id) {
        String query = """
            query ProduceById($id: ID!) {
                produceById(id: $id) {
                    id
                    name
                    quantityPesticides
                    quotaMaxPesticides
                }
            }
            """;

        Map<String, Object> variables = new HashMap<>();
        variables.put("id", id);

        return sendGraphQLRequest(query, variables)
                .map(response -> {
                    Map<String, Object> data = (Map<String, Object>) response.get("data");
                    Map<String, Object> produceByIdData = (Map<String, Object>) data.get("produceById");
                    return objectMapper.convertValue(produceByIdData, Produce.class);
                });
    }

    public Mono<List<Produce>> getAllProduces() {

        String query = """
        query Produces {
          produces {
            id
            name
            quantityPesticides
            quotaMaxPesticides
            farms {
              id
              name
              location
            }
          }
        }
        """;

        return sendGraphQLRequest(query, null)
                .map(response -> {
                    Map<String, Object> data = (Map<String, Object>) response.get("data");
                    List<Map<String, Object>> producesData = (List<Map<String, Object>>) data.get("produces");
                    return producesData.stream()
                            .map(map -> objectMapper.convertValue(map, Produce.class))
                            .toList();
                });
    }


    private Mono<Map> sendGraphQLRequest(String query, Map<String, Object> variables) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("query", query);
        requestBody.put("variables", variables);

        return client.agricultureWebClient().post()
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .onErrorMap(e -> new RuntimeException("Failed to call GraphQL service", e));
    }
}
