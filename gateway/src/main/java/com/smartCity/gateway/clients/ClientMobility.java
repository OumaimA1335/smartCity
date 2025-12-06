package com.smartCity.gateway.clients;

import com.smartCity.gateway.entities.mobility.TransportLine;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/mobility")
public class ClientMobility {
	
	private final WebClient.Builder webClient;

	public ClientMobility(Builder webClient) {
		super();
		this.webClient = webClient;
	}

	@GetMapping("/transportline/{resource}")
	public Mono<String> mobility(@PathVariable Integer resource) {
	    return webClient.build()
	            .get()
	            .uri("http://localhost:8080/smartCity/transportline/"+resource)
	            .retrieve()
	            .bodyToMono(String.class);
	}

    @GetMapping("/transportline")
    public Mono<String> getTransportLines() {
        return webClient.build()
                .get()
                .uri("http://localhost:8080/smartCity/transportline")
                .retrieve()
                .bodyToMono(String.class);
    }
    @PostMapping("/transportline")
    public Mono<String> addTransportLine(@RequestBody TransportLine transportLine) {
        return webClient.build()
                .post()
                .uri("http://localhost:8080/smartCity/transportline")
                .bodyValue(transportLine)
                .retrieve()
                .bodyToMono(String.class);
    }
	

}
