package com.smartCity.mobilityService.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TransportLineDTO {
	@Schema(description="Le nom de station de cette ligne de transport")
    private String stationName;
	@Schema(description="Le type de ligne de transport")
    private String type;
	@Schema(description="La statuts du traffic actuelle de cette ligne de transport")
    private Long traficStatusId;
}
