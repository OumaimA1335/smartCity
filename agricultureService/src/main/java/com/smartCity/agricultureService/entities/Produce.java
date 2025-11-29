package com.smartCity.agricultureService.entities;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produce {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int quantityPesticides;
	private int quotaMaxPesticides;
	@ManyToMany(mappedBy = "Farmproduces")
	private List<Farm> farms;
	@ManyToMany
	private List<OperationPlan> operations;

}
