package com.smartCity.gateway.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class SoapClientConfig {
    @Bean
    public WebServiceTemplate finesServiceTemplate() {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setDefaultUri("http://localhost:8085/ws/fines"); // URL du service SOAP
        webServiceTemplate.setMarshaller(fineMarshaller());
        webServiceTemplate.setUnmarshaller(fineMarshaller());
        return webServiceTemplate;
    }

    @Bean
    public WebServiceTemplate citizenServiceTemplate() {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setDefaultUri("http://localhost:8084/ws/citizen"); // URL du service SOAP
        webServiceTemplate.setMarshaller(citizenMarshaller());
        webServiceTemplate.setUnmarshaller(citizenMarshaller());
        return webServiceTemplate;
    }

    @Bean
    public Jaxb2Marshaller fineMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.smartCity.gateway.entities.fines");
        return marshaller;
    }
    @Bean
    public Jaxb2Marshaller citizenMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

        marshaller.setContextPath("com.smartCity.gateway.entities.citizen");
        return marshaller;
    }
}
