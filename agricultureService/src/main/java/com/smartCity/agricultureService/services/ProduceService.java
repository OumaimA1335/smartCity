package com.smartCity.agricultureService.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartCity.agricultureService.entities.OperationPlan;
import com.smartCity.agricultureService.entities.Produce;
import com.smartCity.agricultureService.repositories.OperationPlanRepository;
import com.smartCity.agricultureService.repositories.PrcoduceRepository;

@Service
public class ProduceService {
	
	@Autowired 
	PrcoduceRepository produceRepository;
	@Autowired
	OperationPlanRepository operationRepo;
	
	public Produce addProduce(String name, int quantityPesticides,int quotaMaxPesticides) {
        Produce produce = new Produce();
        produce.setName(name);;
        produce.setQuantityPesticides(quantityPesticides);
        produce.setQuotaMaxPesticides(quotaMaxPesticides);
        produce.setFarms(new ArrayList<>());
        produce.setOperations(new ArrayList<>());
        return produceRepository.save(produce);
    }
	
	public Optional<Produce> getProduceById(Long id)
	{
		return produceRepository.findById(id);
	}
	public Produce getProduceByName(String name)
	{
		return produceRepository.findByName(name);
	}
	public List<Produce> getProduces()
	{
		return produceRepository.findAll();
	}
	public List<Produce> getProducesByFarmId(Long id)
	{
		return produceRepository.findByFarms_Id(id);
	}

}
