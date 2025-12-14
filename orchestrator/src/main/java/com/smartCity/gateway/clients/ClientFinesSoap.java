package com.smartCity.gateway.clients;


import com.smartCity.gateway.entities.citizen.*;
import com.smartCity.gateway.entities.citizen.Citizen;
import com.smartCity.gateway.entities.fines.*;
import jakarta.xml.bind.JAXBElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.namespace.QName;

@Component
public class ClientFinesSoap {

    @Autowired
    @Qualifier("finesServiceTemplate")
    private WebServiceTemplate finesTemplate;

    @Autowired
    @Qualifier("citizenServiceTemplate")
    private WebServiceTemplate citizensTemplate;


    public ResponseEntity<?> addCitizen( Citizen citizen) {
        try {
            // Création de l'objet request
            AddCitizen addCitizen = new AddCitizen();
            addCitizen.setCitizen(citizen);

            // Enveloppe dans un JAXBElement pour JAXB
            QName qName = new QName("http://services.finesService.smartCity.com/", "addCitizen");
            JAXBElement<AddCitizen> requestElement = new JAXBElement<>(qName, AddCitizen.class, addCitizen);

            // Envoi via WebServiceTemplate
            Object responseObj = citizensTemplate.marshalSendAndReceive(requestElement);

            // Récupération du AddCitizenResponse depuis le JAXBElement
            AddCitizenResponse response;
            if (responseObj instanceof JAXBElement) {
                response = ((JAXBElement<AddCitizenResponse>) responseObj).getValue();
            } else {
                response = (AddCitizenResponse) responseObj;
            }

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de l'appel du service SOAP : " + e.getMessage());
        }
    }



    public ResponseEntity<?> addFine( Fine fine) {
        try {
            // Création de l'objet request
            AddFine addFine = new AddFine();
            addFine.setFine(fine);

            // Enveloppe dans un JAXBElement
            QName qName = new QName("http://services.finesService.smartCity.com/", "addFine");
            JAXBElement<AddFine> requestElement = new JAXBElement<>(qName, AddFine.class, addFine);

            // Envoi via WebServiceTemplate
            Object responseObj = finesTemplate.marshalSendAndReceive(requestElement);

            // Récupération du AddFineResponse depuis le JAXBElement
            AddFineResponse response;
            if (responseObj instanceof JAXBElement) {
                response = ((JAXBElement<AddFineResponse>) responseObj).getValue();
            } else {
                response = (AddFineResponse) responseObj;
            }

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de l'appel du service SOAP : " + e.getMessage());
        }
    }

    public ResponseEntity<?> getCitizenFines( Long id) {
        // Crée la requête
        GetCitizenFines request = new GetCitizenFines();
        request.setId(id);

        // Enveloppe dans un JAXBElement
        QName qName = new QName("http://services.finesService.smartCity.com/", "getCitizenFines");
        JAXBElement<GetCitizenFines> root = new JAXBElement<>(qName, GetCitizenFines.class, request);

        // Appel SOAP
        JAXBElement<GetCitizenFinesResponse> responseElement =
                (JAXBElement<GetCitizenFinesResponse>) citizensTemplate.marshalSendAndReceive(root);

        // Récupère le corps de la réponse
        GetCitizenFinesResponse response = responseElement.getValue();

        return ResponseEntity.ok(response);
    }

    public ResponseEntity<?> getFine( Long idFine,  Long idCitizen) {
        // Crée la requête
        GetFineByIdFineAndIdCitizen request = new GetFineByIdFineAndIdCitizen();
        request.setIdFine(idFine);
        request.setIdCitizen(idCitizen);

        // Enveloppe dans un JAXBElement
        QName qName = new QName("http://services.finesService.smartCity.com/", "getFineByIdFineAndIdCitizen");
        JAXBElement<GetFineByIdFineAndIdCitizen> root = new JAXBElement<>(qName, GetFineByIdFineAndIdCitizen.class, request);

        // Appel SOAP
        JAXBElement<GetFineByIdFineAndIdCitizenResponse> responseElement =
                (JAXBElement<GetFineByIdFineAndIdCitizenResponse>) finesTemplate.marshalSendAndReceive(root);


        // Récupère le corps de la réponse
        GetFineByIdFineAndIdCitizenResponse response = responseElement.getValue();

        return ResponseEntity.ok(response);
    }

}
