package com.smartCity.mobilityService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartCity.mobilityService.DTO.TransportLineDTO;
import com.smartCity.mobilityService.entities.TransportLine;
import com.smartCity.mobilityService.services.TransportLineService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/transportline")

@Tag(name="Lignes des Transports",description="Gestion des lignes de transport dans la vile {Bus/Train/Métro}")
public class TransportLineController {
	@Autowired
	private TransportLineService serviceTransportline;
	
	@PostMapping
	@Operation(summary="ajouter une ligne de transport")
	public TransportLine addTransportLine(@RequestBody TransportLineDTO transportline)
	{
		return serviceTransportline.addTransportLine(transportline);
	}
	@GetMapping("/{id}")
	@Operation(summary="récupérer une ligne de transport bien déterminée")
	public void getTransportLine(@PathVariable Long id)
	{
		serviceTransportline.getTransportLine(id);
	}
	@GetMapping
	@Operation(summary="Récupérer tous les lignes de transports  dans la ville")
	public List<TransportLine> getAllTransportLines() {
	    return serviceTransportline.getAllTransportLine();
	}

	@DeleteMapping("/{id}")
	@Operation(summary="Supprimer une ligne de transport bien déterminée")
	public void deleteTransportLine(@PathVariable  Long id)
	{
		serviceTransportline.deleteTransportLine(id);
	}
	@PutMapping("/{id}")
	@Operation(summary="Modifier une Ligne de transport bien déterminée")
	public void updateTransportLine(@RequestBody TransportLineDTO transportline ,@PathVariable Long id)
	{
		serviceTransportline.modifyTransportLine(transportline, id);
	}
	

}
