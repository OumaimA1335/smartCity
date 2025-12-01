package com.smartCity.weather.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private double temperature;
	private double humidity;
	private double pressure;
	private double windSpeed;
	private String windDirection;
	private String date;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public Weather(Location location, double temperature, int humidity, double pressure, double windSpeed, String windDirection, String date) {
        this.location = location;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.date = date;
    }
}
