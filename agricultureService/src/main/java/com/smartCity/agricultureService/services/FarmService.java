package com.smartCity.agricultureService.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartCity.agricultureService.entities.Farm;
import com.smartCity.agricultureService.entities.Produce;
import com.smartCity.agricultureService.repositories.FarmRepository;
import com.smartCity.agricultureService.repositories.PrcoduceRepository;

@Service
public class FarmService {

	@Autowired
	FarmRepository farmRepository;
	@Autowired
	PrcoduceRepository produceRepository;
	public Farm addFarm(String name, String location) {
        Farm farm = new Farm();
        farm.setName(name);
        farm.setLocation(location);
        farm.setFarmproduces(new ArrayList<>());
        return farmRepository.save(farm);
    }
	public Farm assignProduceToFarm(Long farmId, Long produceId) {
        Farm farm = farmRepository.findById(farmId)
                .orElseThrow(() -> new RuntimeException("Farm not found"));

        Produce produce = produceRepository.findById(produceId)
                .orElseThrow(() -> new RuntimeException("Produce not found"));

        farm.getFarmproduces().add(produce);
        return farmRepository.save(farm);
    }
	public Farm getFarmById(Long id)
	{
		return farmRepository.findById(id).orElse(null);
	}
	public List<Farm> getFarms()
	{
		return farmRepository.findAll();
	}
	
}
