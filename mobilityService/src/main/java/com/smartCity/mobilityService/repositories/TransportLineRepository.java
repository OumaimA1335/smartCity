package com.smartCity.mobilityService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartCity.mobilityService.entities.TransportLine;

public interface TransportLineRepository extends JpaRepository<TransportLine,Long> {

}
