package com.naleen.microservices.convertcurrencyservice.entities;

public class CurrencyConversionBean {
	
	private int id;
	
	private String from;
	
	private String to;

	private Double conversionFactor;
	
	private int amount;
	
	private Double convertedAmount;
	
	private int port;
	
	public CurrencyConversionBean() {}

	public CurrencyConversionBean(int id, String from, String to, Double conversionFactor, int amount,
			Double convertedAmount,int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionFactor = conversionFactor;
		this.amount = amount;
		this.convertedAmount = convertedAmount;
		this.port = port;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Double getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(Double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Double getConvertedAmount() {
		return convertedAmount;
	}

	public void setConvertedAmount(Double convertedAmount) {
		this.convertedAmount = convertedAmount;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "CurrencyConversionBean [id=" + id + ", from=" + from + ", to=" + to + ", conversionFactor="
				+ conversionFactor + ", amount=" + amount + ", convertedAmount=" + convertedAmount + "]";
	}
	
	
	
	
}
