package com.smartCity.mobilityService.entities;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Trafic {
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private Long trafficId;
	@Schema(description="la statut du traffic")
	@NotNull
	private String Status;
	@Schema(description="une courte description")
	@NotNull
	private String description;
	@Schema(description="la ligne de transport est annulée ou pas")
	private Boolean canceled;
	@Schema(description="la ligne de transport est en retard ou non")
	private Boolean beLate;
	@Schema(description="Si oui -> la marge de retard")
	@Column(nullable = true)
	private Integer toleranceTimeMinutes;	

}
