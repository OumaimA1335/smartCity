package com.smartCity.gateway.entities.orchestrator;

import java.time.LocalTime;

public class OrchestratorOverView {
    private Long idCitizen;
    private String city;
    private  String date;
    private  String produceName;
    private String operationType;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private String stationDepart;
    private String stationArrivee;
    private Long transportLineId;

    public OrchestratorOverView(Long idCitizen, String city, String date, String produceName, String operationType, LocalTime departureTime, LocalTime arrivalTime, String stationDepart, String stationArrivee, Long transportLineId) {
        this.idCitizen = idCitizen;
        this.city = city;
        this.date = date;
        this.produceName = produceName;
        this.operationType = operationType;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.stationDepart = stationDepart;
        this.stationArrivee = stationArrivee;
        this.transportLineId = transportLineId;
    }

    public Long getIdCitizen() {
        return idCitizen;
    }

    public void setIdCitizen(Long idCitizen) {
        this.idCitizen = idCitizen;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProduceName() {
        return produceName;
    }

    public void setProduceName(String produceName) {
        this.produceName = produceName;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getStationDepart() {
        return stationDepart;
    }

    public void setStationDepart(String stationDepart) {
        this.stationDepart = stationDepart;
    }

    public String getStationArrivee() {
        return stationArrivee;
    }

    public void setStationArrivee(String stationArrivee) {
        this.stationArrivee = stationArrivee;
    }

    public Long getTransportLineId() {
        return transportLineId;
    }

    public void setTransportLineId(Long transportLineId) {
        this.transportLineId = transportLineId;
    }
}
