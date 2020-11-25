package com.naleen.microservices.convertcurrencyservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.naleen.microservices.convertcurrencyservice.entities.CurrencyConversionBean;

//@FeignClient(name = "conversion-factor-service", url = "localhost:8000")
@FeignClient(name="conversion-factor-service")
@RibbonClient(name="conversion-factor-service")
public interface ConversionFactorServiceProxy {

	@GetMapping("/conversion-factor/from/{from}/to/{to}")
	public CurrencyConversionBean getConversionFactor(@PathVariable String from, @PathVariable String to);

}
