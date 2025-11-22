package com.smartCity.mobilityService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartCity.mobilityService.entities.Schedule;


public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
