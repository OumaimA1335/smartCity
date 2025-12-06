package com.smartCity.gateway.entities.fines;

public class Fines {
    private Long id;
    private double amount;
    private String reason;
    private boolean paid;
    private Long citizen_id;

    public Fines(Long id, double amount, String reason, boolean paid, Long citizen_id) {
        this.id = id;
        this.amount = amount;
        this.reason = reason;
        this.paid = paid;
        this.citizen_id = citizen_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Long getCitizen_id() {
        return citizen_id;
    }

    public void setCitizen_id(Long citizen_id) {
        this.citizen_id = citizen_id;
    }
}
