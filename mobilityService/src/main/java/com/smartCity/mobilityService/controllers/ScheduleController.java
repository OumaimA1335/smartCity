package com.smartCity.mobilityService.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartCity.mobilityService.DTO.ScheduleDTO;
import com.smartCity.mobilityService.entities.Schedule;
import com.smartCity.mobilityService.services.ScheduleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/schedule")
@Tag(name="Horraire",description="Gestion des horaires des lignes de transport")
public class ScheduleController {
	@Autowired
	private ScheduleService scheduleService;
	
	@PostMapping
	@Operation(summary="ajouter un horaire",description ="créer un nouvel horaire pour la ligne de transport")
	public Schedule addSchedule(@RequestBody ScheduleDTO schedule)
	{
		return scheduleService.addSchedule(schedule);
	}
	@GetMapping("/{id}")
	@Operation(summary="récupérer un horaire par son id")
	public Optional<Schedule> getSchedule(@PathVariable Long id)
	{
		return scheduleService.getSchedule(id);
	}
	@GetMapping
	@Operation(summary="récupérer la liste des horaires")
	public List<Schedule> getAllSchedule() {
	    return scheduleService.getAllSchedule();
	}

	@DeleteMapping("/{id}")
	@Operation(summary="Supprimer un horraire")
	public void deleteSchedule(@PathVariable Long id)
	{
		scheduleService.deleteSchedule(id);;
	}
	@PutMapping("/{id}")
	@Operation(summary="Modifier un Horraire")
	public void updateSchedule(@RequestBody ScheduleDTO shedule , @PathVariable Long id)
	{
		scheduleService.modifySchedule(shedule, id);;
	}
	@GetMapping("/{s1}/{s2}")
	@Operation(summary="Faire la correspondance entre deux lignes de transports différents")
	public String correspondanceBetweenTwoLineTranport(@PathVariable Long s1,@PathVariable Long s2)
	{
		 return scheduleService.corresspondance(s1, s2);
	}
}
