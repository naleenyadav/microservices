package com.naleen.microservices.convertcurrencyservice.resource;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.naleen.microservices.convertcurrencyservice.ConversionFactorServiceProxy;
import com.naleen.microservices.convertcurrencyservice.entities.CurrencyConversionBean;

@RestController
public class ConvertCurrencyController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ConversionFactorServiceProxy proxy;

	@GetMapping("/convert-currency/from/{from}/to/{to}/amount/{amount}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable int amount) {

		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/conversion-factor/from/{from}/to/{to}", CurrencyConversionBean.class,
				uriVariables);

		CurrencyConversionBean currencyConversionBean = responseEntity.getBody();

		return new CurrencyConversionBean(currencyConversionBean.getId(), currencyConversionBean.getFrom(),
				currencyConversionBean.getTo(), currencyConversionBean.getConversionFactor(), amount,
				amount * currencyConversionBean.getConversionFactor(),currencyConversionBean.getPort());

	}
	
	@GetMapping("/convert-currency-feign/from/{from}/to/{to}/amount/{amount}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable int amount) {

		CurrencyConversionBean currencyConversionBean = proxy.getConversionFactor(from, to);
		 logger.info("{}",currencyConversionBean);
		return new CurrencyConversionBean(currencyConversionBean.getId(), currencyConversionBean.getFrom(),
				currencyConversionBean.getTo(), currencyConversionBean.getConversionFactor(), amount,
				amount * currencyConversionBean.getConversionFactor(),currencyConversionBean.getPort());

	}

}
