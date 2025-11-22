package com.smartCity.mobilityService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartCity.mobilityService.entities.Trafic;

public interface TrafficRepository extends JpaRepository<Trafic, Long> {

}
