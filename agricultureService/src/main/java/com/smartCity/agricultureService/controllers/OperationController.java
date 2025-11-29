package com.smartCity.agricultureService.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.smartCity.agricultureService.entities.Farm;
import com.smartCity.agricultureService.entities.OperationPlan;
import com.smartCity.agricultureService.entities.Produce;
import com.smartCity.agricultureService.services.OperationPlanService;

@Controller
public class OperationController {
	@Autowired
	private OperationPlanService operationService;
	
	
	@MutationMapping
    public OperationPlan  addOperationPlan(@Argument String operationType,@Argument String plannedDate){
        return operationService.addOperationPlan(operationType, plannedDate);
    }
	@QueryMapping
	public OperationPlan operationPlanById (@Argument Long id)
	{
		return operationService.getPlanById(id);
	}
	@QueryMapping
	public List<OperationPlan> operationPlans ()
	{
		return operationService.getAllPlans();
	}
	 @MutationMapping
	  public OperationPlan  assignProduceToOperationPlan(@Argument Long produceId,@Argument Long planId){
	      return operationService.assignProduceToOperationPlan(planId, produceId);
	  }
	 @SchemaMapping(typeName = "OperationPlan", field = "produces")
	 public List<Produce> getProduces(OperationPlan operationPlan) {
	     return operationPlan.getProducesOperation() != null ? operationPlan.getProducesOperation() : new ArrayList<>();
	 }


}
