package com.smartCity.finesService.entities;


import jakarta.xml.bind.annotation.*;

@XmlRootElement(name="fine")                
@XmlAccessorType(XmlAccessType.FIELD)    
public class Fine {

    private Long id;
    private double amount;
    private String reason;
    private boolean paid;
    private Long citizen_id;
	public Fine(double amount, String reason, boolean paid, Long citizen_id) {
		super();
		this.amount = amount;
		this.reason = reason;
		this.paid = paid;
		this.citizen_id = citizen_id;
	}
	
	public Fine() {
		super();
		// TODO Auto-generated constructor stub
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
