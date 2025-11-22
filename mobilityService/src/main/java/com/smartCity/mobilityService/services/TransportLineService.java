package com.smartCity.mobilityService.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartCity.mobilityService.DTO.TransportLineDTO;
import com.smartCity.mobilityService.entities.Trafic;
import com.smartCity.mobilityService.entities.TransportLine;
import com.smartCity.mobilityService.repositories.TrafficRepository;
import com.smartCity.mobilityService.repositories.TransportLineRepository;

@Service
public class TransportLineService {
	
	@Autowired
	private TransportLineRepository repoTransportLine;
	
	@Autowired 
	private TrafficRepository repoTraffic;
	
	public TransportLine  addTransportLine(TransportLineDTO transportLineDTO)
	{
		TransportLine line = new TransportLine();
        line.setStationName(transportLineDTO.getStationName());
        line.setType(transportLineDTO.getType());
             if (transportLineDTO.getTraficStatusId() != null) {
            Trafic trafic = repoTraffic.findById(transportLineDTO.getTraficStatusId())
                    .orElseThrow(() -> new RuntimeException(
                            "Trafic not found with id: " + transportLineDTO.getTraficStatusId()
                    ));

            line.setTraficStatus(trafic);
        }

        return repoTransportLine.save(line);
	}
	public Optional<TransportLine>  getTransportLine(Long id)
	{
		return repoTransportLine.findById(id);
	}
	public List<TransportLine>  getAllTransportLine()
	{
		return repoTransportLine.findAll();
	}
	public void modifyTransportLine(TransportLineDTO transportLineDTO, Long id) {
	    Optional<TransportLine> existingLine = this.getTransportLine(id);
	    if (existingLine != null) {
	      
	        existingLine.get().setStationName(transportLineDTO.getStationName());
	        existingLine.get().setType(transportLineDTO.getType());
	        if (transportLineDTO.getTraficStatusId() != null) {
	            Trafic trafic = repoTraffic.findById(transportLineDTO.getTraficStatusId())
	                    .orElseThrow(() -> new RuntimeException(
	                            "Trafic not found with id: " + transportLineDTO.getTraficStatusId()
	                    ));

	            existingLine.get().setTraficStatus(trafic);;
	        }

	        repoTransportLine.save(existingLine.get());
	    } else {
	        throw new RuntimeException("TransportLine with id " + id + " not found");
	    }
	}
	public void  deleteTransportLine(Long id)
	{
		repoTransportLine.deleteById(id);
	}


}
