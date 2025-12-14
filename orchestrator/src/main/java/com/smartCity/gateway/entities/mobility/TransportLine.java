package com.smartCity.gateway.entities.mobility;

public class TransportLine {
    private String stationName;
    private String type;
    private Long traficStatusId;

    public TransportLine(String stationName, String type, Long traficStatusId) {
        this.stationName = stationName;
        this.type = type;
        this.traficStatusId = traficStatusId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getTraficStatusId() {
        return traficStatusId;
    }

    public void setTraficStatusId(Long traficStatusId) {
        this.traficStatusId = traficStatusId;
    }
}
