package com.smartCity.finesService;


import com.smartCity.finesService.services.CitizenService;
import com.smartCity.finesService.services.FinesService;

import jakarta.xml.ws.Endpoint;

public class FinesServiceApplication {

	public static void main(String[] args) {
	
		 System.out.println("Starting SOAP Services ...\n");
		 System.out.println("Citizen service started on port 8084...\n");
		 Endpoint.publish("http://0.0.0.0:8084/ws/citizen", new CitizenService());
		 System.out.println("Fines service started on port 8085...\n");
		 Endpoint.publish("http://0.0.0.0:8085/ws/fines", new FinesService());
	}

}
