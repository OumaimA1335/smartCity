package com.smartCity.gateway.entities.mobility;

import java.time.LocalTime;

public class Schedules {
    private Long id;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private String stationDepart;
    private String stationArrivee;
    private Long transportLineId; // Id de la ligne associée

    public Schedules(Long id, LocalTime departureTime, LocalTime arrivalTime, String stationDepart, String stationArrivee, Long transportLineId, String transportLineName) {
        this.id = id;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.stationDepart = stationDepart;
        this.stationArrivee = stationArrivee;
        this.transportLineId = transportLineId;

    }

    public Schedules(LocalTime departureTime, LocalTime arrivalTime, String stationDepart, String stationArrivee, Long transportLineId) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.stationDepart = stationDepart;
        this.stationArrivee = stationArrivee;
        this.transportLineId = transportLineId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
