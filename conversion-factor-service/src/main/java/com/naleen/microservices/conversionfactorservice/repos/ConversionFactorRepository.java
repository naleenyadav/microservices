package com.naleen.microservices.conversionfactorservice.repos;

import org.springframework.data.repository.CrudRepository;

import com.naleen.microservices.conversionfactorservice.entities.ExchangeValue;

public interface ConversionFactorRepository extends CrudRepository<ExchangeValue, Integer> {
	
	ExchangeValue findByFromAndTo(String from, String to);

}
