package com.smartCity.agricultureService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartCity.agricultureService.entities.OperationPlan;
import com.smartCity.agricultureService.entities.Produce;

public interface OperationPlanRepository extends JpaRepository<OperationPlan, Long> {
	  List<OperationPlan> findByProducesOperation_Id(Long produceId);
}
