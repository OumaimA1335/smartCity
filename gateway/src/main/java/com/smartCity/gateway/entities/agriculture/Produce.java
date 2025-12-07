package com.smartCity.gateway.entities.agriculture;

import java.util.List;

public class Produce {
    private Long id;
    private String name;
    private int quantityPesticides;
    private int quotaMaxPesticides;
    private List<Farm> farms;

    public Produce(Long id ,String name, int quantityPesticides, int quotaMaxPesticides, List<Farm> farms) {
        this.id = id;
        this.name = name;
        this.quantityPesticides = quantityPesticides;
        this.quotaMaxPesticides = quotaMaxPesticides;
        this.farms = farms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Farm> getFarms() {
        return farms;
    }

    public void setFarms(List<Farm> farms) {
        this.farms = farms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityPesticides() {
        return quantityPesticides;
    }

    public void setQuantityPesticides(int quantityPesticides) {
        this.quantityPesticides = quantityPesticides;
    }

    public int getQuotaMaxPesticides() {
        return quotaMaxPesticides;
    }

    public void setQuotaMaxPesticides(int quotaMaxPesticides) {
        this.quotaMaxPesticides = quotaMaxPesticides;
    }
}
