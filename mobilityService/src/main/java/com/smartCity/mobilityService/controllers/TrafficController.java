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
import com.smartCity.mobilityService.entities.Trafic;
import com.smartCity.mobilityService.services.TrafficService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/traffic")
@Tag(name="Statut du traffic",description="Gestion de l'état du traffic d'une ligne de transport bien déterminée")
public class TrafficController {
	@Autowired
	private TrafficService trafficService;
	
	@PostMapping
	@Operation(summary="ajouter un états de traffic")
	public void addTraffic(@RequestBody Trafic traffic)
	{
		trafficService.addtraffic(traffic);
	}
	@GetMapping("/{id}")
	@Operation(summary="récupérer un états de traffic bien déterminée")
	public void getTraffic( @PathVariable Long id)
	{
		trafficService.getTrafic(id);
	}
	@GetMapping("/traffics")
	@Operation(summary="Récupérer tous un états de traffic disponible")
	public List<Trafic> getAllTraffic() {
	    return trafficService.getAllTrafic();
	}

	@DeleteMapping("/{id}")
	@Operation(summary="Supprimer un états de traffic bien déterminée")
	public void deleteTraffic(@PathVariable Long id)
	{
		trafficService.deleteTrafic(id);;
	}
	@PutMapping("/{id}")
	@Operation(summary="Modifier un états de traffic bien déterminée")
	public void updateTrafic(@RequestBody Trafic trafic,@PathVariable Long id)
	{
		trafficService.modifytrafic(trafic, id);
	}

}
