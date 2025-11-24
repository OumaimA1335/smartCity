package com.smartCity.finesService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartCity.finesService.entities.Fine;

public interface FineRepository extends JpaRepository<Fine, Long> {

}

