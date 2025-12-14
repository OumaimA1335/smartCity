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
import com.smartCity.agricultureService.entities.OperationPlan;
import com.smartCity.agricultureService.entities.Produce;
import com.smartCity.agricultureService.services.ProduceService;

@Controller
public class ProduceController {
  @Autowired
  ProduceService produceSer;
  @MutationMapping
  public Produce  addProduce(@Argument String name,@Argument int quantityPesticides,@Argument int quotaMaxPesticides){
      return produceSer.addProduce(name, quantityPesticides, quotaMaxPesticides);
  }
     @QueryMapping
	public Optional<Produce> produceById (@Argument Long id)
	{
		return produceSer.getProduceById(id);
	}
	@QueryMapping
	public List<Produce> produces ()
	{
		return produceSer.getProduces();
	}
	@QueryMapping
	public Produce getProduceByName (@Argument String name)
	{
		return produceSer.getProduceByName(name);
	}
	 @SchemaMapping(typeName = "Produce", field = "operations")
	 public List<OperationPlan> getOperation(Produce produce) {
	     return produce.getOperations() != null ? produce.getOperations() : new ArrayList<>();
	 }
	 @SchemaMapping(typeName = "Produce", field = "farms")
	 public List<Farm> getFarm(Produce produce) {
	     return produce.getFarms() != null ? produce.getFarms() : new ArrayList<>();
	 }
}
