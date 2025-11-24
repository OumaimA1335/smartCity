package com.smartCity.finesService.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
public class Fine {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long farmerId;
	private BigDecimal amount;
	private String reason;
	private boolean paid;
	private LocalDateTime createdAt;
	@ManyToOne
	@JoinColumn(name = "citizen_id")
	private Citizen citizen;
	@OneToOne(cascade = CascadeType.ALL)
	private Payment paymentFee;
	
	
	
}
