package com.smartCity.gateway.entities.fines;

public class Citizen {
    private Long id;
    private String nationalIdNumber;
    private String FullName;
    private String gender;
    private String nationnality;
    private String phoneNumber;
    private String address;
    private String profession;

    public Citizen(Long id, String nationalIdNumber, String fullName, String gender, String nationnality, String phoneNumber, String address, String profession) {
        this.id = id;
        this.nationalIdNumber = nationalIdNumber;
        FullName = fullName;
        this.gender = gender;
        this.nationnality = nationnality;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.profession = profession;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNationalIdNumber() {
        return nationalIdNumber;
    }

    public void setNationalIdNumber(String nationalIdNumber) {
        this.nationalIdNumber = nationalIdNumber;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationnality() {
        return nationnality;
    }

    public void setNationnality(String nationnality) {
        this.nationnality = nationnality;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
