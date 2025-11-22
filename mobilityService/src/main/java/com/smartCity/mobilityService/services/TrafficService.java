package com.smartCity.mobilityService.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smartCity.mobilityService.entities.Trafic;
import com.smartCity.mobilityService.repositories.TrafficRepository;

@Service
public class TrafficService {
	@Autowired 
	private TrafficRepository traficrepo;
	

	public void  addtraffic(Trafic trafic)
	{
		 traficrepo.save(trafic);
	}
	public Optional<Trafic>  getTrafic(Long id)
	{
		return traficrepo.findById(id);
	}
	public List<Trafic>  getAllTrafic()
	{
		return traficrepo.findAll();
	}
	public void modifytrafic(Trafic trafic, Long id) {
	    Optional<Trafic> existingTrafic = this.getTrafic(id);
	    if (existingTrafic != null) {
	      
	    	existingTrafic.get().setDescription(trafic.getDescription());
	    	existingTrafic.get().setStatus(trafic.getStatus());
	    	existingTrafic.get().setBeLate(trafic.getBeLate());
	    	existingTrafic.get().setCanceled(trafic.getCanceled());
	    	existingTrafic.get().setToleranceTimeMinutes(trafic.getToleranceTimeMinutes());
	    	traficrepo.save(existingTrafic.get());
	    } else {
	        throw new RuntimeException("TransportLine with id " + id + " not found");
	    }
	}
	public void  deleteTrafic(Long id)
	{
		traficrepo.deleteById(id);
	}

}

