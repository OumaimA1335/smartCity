package com.smartCity.agricultureService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.smartCity.agricultureService.entities.Produce;


public interface PrcoduceRepository extends JpaRepository<Produce, Long> {
  
	  List<Produce> findByFarms_Id(Long farmId);
	 
}
