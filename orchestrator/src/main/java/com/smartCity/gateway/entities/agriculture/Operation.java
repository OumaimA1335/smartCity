package com.smartCity.gateway.entities.agriculture;

import java.util.List;

public class Operation {
    private Long id;
    private String operationType;
    private String plannedDate;
    private List<Long> produceIds;

    public Operation(Long id, String operationType, String plannedDate, List<Long> produceIds) {
        this.id = id;
        this.operationType = operationType;
        this.plannedDate = plannedDate;
        this.produceIds = produceIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getPlannedDate() {
        return plannedDate;
    }

    public void setPlannedDate(String plannedDate) {
        this.plannedDate = plannedDate;
    }

    public List<Long> getProduceIds() {
        return produceIds;
    }

    public void setProduceIds(List<Long> produceIds) {
        this.produceIds = produceIds;
    }
}
