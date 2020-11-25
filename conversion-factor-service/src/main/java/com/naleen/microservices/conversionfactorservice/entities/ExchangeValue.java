package com.naleen.microservices.conversionfactorservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class ExchangeValue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "currency_from")
	@NotNull
	@NotEmpty(message = "Currency from field cannot be empty")
	private String from;

	@Column(name = "currency_to")
	@NotNull
	@NotEmpty(message = "Currency to field cannot be empty")
	private String to;

	@NotNull
	private Double conversionFactor;

	private int port;

	public ExchangeValue() {
	}

	public ExchangeValue(int id, @NotNull @NotEmpty(message = "Currency from field cannot be empty") String from,
			@NotNull @NotEmpty(message = "Currency to field cannot be empty") String to,
			@NotNull Double conversionFactor, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionFactor = conversionFactor;
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

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "ExchangeValue [id=" + id + ", from=" + from + ", to=" + to + ", conversionFactor=" + conversionFactor
				+ "]";
	}

}
