package com.smartCity.mobilityService.DTO;

import java.time.LocalTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDTO {
    private Long id;
    @Schema(description="Heure de départ")
    private LocalTime departureTime;
    @Schema(description="Heure d'arrivée")
    private LocalTime arrivalTime;
    @Schema(description="station de départ")
    private String stationDepart;
    @Schema(description="Heure d'arrivée")
    private String stationArrivee;
    @Schema(description="La ligne de transport qui correspond à ce horraire")
    private Long transportLineId;} 
