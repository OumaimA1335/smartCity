package com.smartCity.agricultureService.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.smartCity.agricultureService.entities.Farm;
import com.smartCity.agricultureService.entities.Produce;
import com.smartCity.agricultureService.services.FarmService;
import com.smartCity.agricultureService.services.ProduceService;

@Controller
public class FarmController {
	@Autowired
	private FarmService farmService;
	@Autowired
	private ProduceService produceService;
	
	@MutationMapping
    public Farm addFarm(@Argument String name, @Argument String location) {
        return farmService.addFarm(name, location);
    }
	@MutationMapping
    public Farm assignProduceToFarm(@Argument Long farmId, @Argument Long produceId) {
        return farmService.assignProduceToFarm(farmId, produceId);
    }
	@QueryMapping
	public Farm farmById (@Argument Long id)
	{
		return farmService.getFarmById(id);
	}
	@QueryMapping
	public List<Farm> farms ()
	{
		return farmService.getFarms();
	}
	 @SchemaMapping(typeName = "Farm", field = "produces")
	 public List<Produce> getProduces(Farm farm) {
	     return farm.getFarmproduces() != null ? farm.getFarmproduces() : new ArrayList<>();
	 }


}
