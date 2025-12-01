package com.smartCity.weather.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartCity.weather.entities.Weather;

import java.util.Optional;

public interface WeatherRepository extends JpaRepository<Weather, Long> {

    Optional<Weather> findByLocationCityAndDate(String city, String date);
}
