package com.smartCity.agricultureService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.smartCity.agricultureService.entities.Farm;


public interface FarmRepository extends JpaRepository<Farm, Long> {

	
}
