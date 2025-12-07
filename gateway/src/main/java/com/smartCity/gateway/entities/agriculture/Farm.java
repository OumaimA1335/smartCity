package com.smartCity.gateway.entities.agriculture;

import java.util.List;

public class Farm {
    private Long id;
    private String name;
    private String location;
    private List<Produce> produceIds;

    public Farm(Long id, String name, String location, List<Produce> produceIds) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.produceIds = produceIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Produce> getProduceIds() {
        return produceIds;
    }

    public void setProduceIds(List<Produce> produceIds) {
        this.produceIds = produceIds;
    }
}
