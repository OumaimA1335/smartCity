package com.smartCity.agricultureService.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartCity.agricultureService.entities.OperationPlan;
import com.smartCity.agricultureService.entities.Produce;
import com.smartCity.agricultureService.repositories.OperationPlanRepository;
import com.smartCity.agricultureService.repositories.PrcoduceRepository;

@Service
public class OperationPlanService {
   @Autowired
   OperationPlanRepository operationRepo;
   @Autowired 
   PrcoduceRepository produceRepo;
   
   public OperationPlan addOperationPlan(String operationType,String plannedDate) {
	   OperationPlan operation = new OperationPlan();
	   operation.setOperationType(operationType);
	   operation.setPlannedDate(plannedDate);
       operation.setProducesOperation(new ArrayList<>());
	   return operationRepo.save(operation);
	   
   }
   public List<OperationPlan> getAllPlans() {
       return operationRepo.findAll();
   }

   public OperationPlan getPlanById(Long id) {
       return operationRepo.findById(id).orElse(null);
   }
   public OperationPlan assignProduceToOperationPlan(Long operationId, Long produceId) {
       OperationPlan operation = operationRepo.findById(operationId)
               .orElseThrow(() -> new RuntimeException("Operation not found"));

       Produce produce = produceRepo.findById(produceId)
               .orElseThrow(() -> new RuntimeException("Produce not found"));

       operation.getProducesOperation().add(produce);
       return operationRepo.save(operation);
   }
   public OperationPlan getOperationByOperationType(String operationType)
   {
	   return operationRepo.findByOperationType(operationType);
   }
}
