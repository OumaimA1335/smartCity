package com.smartCity.mobilityService.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransportLine {
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private Long idTransportLine;
@Schema(description="Le nom de station de cette ligne de transport")
private String stationName;
@Schema(description="Le type de ligne de transport")
private String type;
@Schema(description="Jointure : une ligne de transport peut avoir plusieurs horraires")
@JsonIgnore
@OneToMany(mappedBy = "transportLine", cascade = CascadeType.ALL, orphanRemoval = true)
private List<Schedule> schedules = new ArrayList<>();
@Schema(description="Plusieurs lignes de transport peut avoir le meme traffic statut")
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "traffic_id", referencedColumnName = "trafficId")
private Trafic traficStatus;

}
