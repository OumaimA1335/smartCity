package com.smartCity.mobilityService.entities;

import java.time.LocalTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Schema(description="Heure de départ")
    private LocalTime departureTime;
	@Schema(description="Heure d'arrivée")
    private LocalTime arrivalTime;
	@Schema(description="Station de départ")
    private String stationDepart;
	@Schema(description="station d'arrivée")
    private String stationArrivee;
	@Schema(description="Jointure : un horraire peut etre attribuée à plusieurs lignes de transport")
    @ManyToOne
    @JoinColumn(name = "transport_line_id")
    private TransportLine transportLine;

}
