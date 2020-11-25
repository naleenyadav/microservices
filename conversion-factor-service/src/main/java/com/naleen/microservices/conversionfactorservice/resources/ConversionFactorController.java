package com.naleen.microservices.conversionfactorservice.resources;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.naleen.microservices.conversionfactorservice.entities.ExchangeValue;
import com.naleen.microservices.conversionfactorservice.exception.ConversionFactorNotFoundException;
import com.naleen.microservices.conversionfactorservice.repos.ConversionFactorRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ConversionFactorController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment env;

	@Autowired
	private ConversionFactorRepository conFactorRepository;

	@PostMapping("/conversion-factor")
	@ResponseStatus(value = HttpStatus.CREATED, reason = "Conversion Factor Added")
	public ExchangeValue addConversionFactor(@Valid @RequestBody ExchangeValue request) {

		return conFactorRepository.save(request);
	}

	@GetMapping("/conversion-factor/from/{from}/to/{to}")
	@HystrixCommand(fallbackMethod = "defaultConversionFactor")
	public ExchangeValue getConversionFactor(@PathVariable String from, @PathVariable String to) {

		
		  ExchangeValue exchangeValue = conFactorRepository.findByFromAndTo(from, to);
		  if (exchangeValue == null) { throw new
		  ConversionFactorNotFoundException("No data found in db"); }
		  
		  exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port"))); 
		  logger.info("{}",exchangeValue);
		  return exchangeValue;
	
	}

	@PutMapping("/conversion-factor")
	@ResponseStatus(value = HttpStatus.OK, reason = "Conversion Factor Updated")
	public ExchangeValue updateConversionFactor(@Valid @RequestBody ExchangeValue request) {
		return conFactorRepository.save(request);
	}
	
	public ExchangeValue defaultConversionFactor(String from,String to) {
		
		return new ExchangeValue(0,"USD","INR",0d,0);
	}

}
