package com.smartCity.weather.repositories;

import com.smartCity.weather.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
