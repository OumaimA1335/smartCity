package com.smartCity.finesService.services;

import java.sql.SQLException;
import java.util.List;
import com.smartCity.finesService.entities.Fine;
import com.smartCity.finesService.repositories.FinesRepository;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public class FinesService {
	
	 private FinesRepository fineRepo;
	 
	 public FinesService() {
	        try {
	        	fineRepo = new FinesRepository(); 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    @WebMethod(operationName = "getFine")
	    public Fine getFine(@WebParam(name = "id") Long id) {
	        try {
				return fineRepo.getFineById(id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
	    }
	 
	    @WebMethod(operationName = "getFines")
	    public List<Fine> getFines() {
	        try {
				return fineRepo.getFines();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
	    }
	    @WebMethod(operationName = "getFineByIdFineAndIdCitizen")
	    public Fine getFineByIdFineAndIdCitizen(@WebParam(name = "idFine") Long idFine,@WebParam(name="idCitizen") Long idCitizen) {
	        try {
				return fineRepo.findFineByIdCitizenAndByIdFine(idCitizen, idFine);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
	    }
	 
	    @WebMethod(operationName = "addFine")
	    public Fine addFine(@WebParam(name="fine")Fine fine) {
	        try {
				return fineRepo.save(fine);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return fine;
	    }
	
}
