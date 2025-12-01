package com.smartCity.finesService.services;

import java.sql.SQLException;
import java.util.List;

import com.smartCity.finesService.entities.Citizen;
import com.smartCity.finesService.entities.Fine;
import com.smartCity.finesService.repositories.CitizennRepository;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public class CitizenService {

	 private CitizennRepository citizenRepo;

	    public CitizenService() {
	        try {
	            citizenRepo = new CitizennRepository(); 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    @WebMethod(operationName = "getCitizenFines")
	    public List<Fine> getCitizenFines(@WebParam(name = "id") Long id) {
	        try {
				return citizenRepo.findByIdWithFines(id);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return null;
	    }
	 
	 @WebMethod(operationName = "getCitizens")
	    public List<Citizen> getCitizens() {
	        try {
				return citizenRepo.getCitizens();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
	    }
	 
	 @WebMethod(operationName = "getCitizenById")
	    public Citizen getCitizenById(Long id) {
	        try {
				return citizenRepo.getCitizenById(id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
	    }
	 
	 @WebMethod
	 public  Citizen addCitizen(@WebParam(name="citizen") Citizen citizen) {
	   try {
		return citizenRepo.save(citizen);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return citizen;
	  
	 }

	
	 
}
