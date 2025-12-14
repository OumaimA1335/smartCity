package com.smartCity.gateway.clients;

import com.smartCity.gateway.entities.mobility.Schedules;
import com.smartCity.gateway.entities.mobility.TransportLine;
import org.apache.maven.lifecycle.Schedule;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

import reactor.core.publisher.Mono;

@Component
public class ClientMobilityRest {
	
	private final WebClient.Builder webClient;

	public ClientMobilityRest(Builder webClient) {
		super();
		this.webClient = webClient;
	}


	public Mono<String> mobility( Integer resource) {
	    return webClient.build()
	            .get()
	            .uri("http://localhost:8080/smartCity/transportline/"+resource)
	            .retrieve()
	            .bodyToMono(String.class);
	}


    public Mono<String> getTransportLines() {
        return webClient.build()
                .get()
                .uri("http://localhost:8080/smartCity/transportline")
                .retrieve()
                .bodyToMono(String.class);
    }
    public Mono<String> getSchedules() {
        return webClient.build()
                .get()
                .uri("http://localhost:8080/smartCity/schedule")
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> addTransportLine( TransportLine transportLine) {
        return webClient.build()
                .post()
                .uri("http://localhost:8080/smartCity/transportline")
                .bodyValue(transportLine)
                .retrieve()
                .bodyToMono(String.class);
    }
    public Mono<String> addSchedule(Schedules schedule) {
        return webClient.build()
                .post()
                .uri("http://localhost:8080/smartCity/schedule")
                .bodyValue(schedule)
                .retrieve()
                .bodyToMono(String.class);
    }
	

}
