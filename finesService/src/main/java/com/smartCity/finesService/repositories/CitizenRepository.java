package com.smartCity.finesService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartCity.finesService.entities.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {

}
