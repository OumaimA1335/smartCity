package com.smartCity.gateway.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.WebServiceTemplate;

public class Soapservice {
    @Autowired
    private WebServiceTemplate webServiceTemplate;

    public Object callSoapService(Object request) {
        return webServiceTemplate.marshalSendAndReceive(request);
    }
}
