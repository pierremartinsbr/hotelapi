package com.hotel.api.model;

import java.math.BigDecimal;

public class PriceDetail {
	
	private BigDecimal pricePerDayAdult =  new BigDecimal(0.0);
	private BigDecimal pricePerDayChild =  new BigDecimal(0.0);
	
	public PriceDetail() {
		super();
	}
	
	public PriceDetail(BigDecimal pricePerDayAdult, BigDecimal pricePerDayChild) {
		super();
		this.pricePerDayAdult = pricePerDayAdult;
		this.pricePerDayChild = pricePerDayChild;
	}
	
	public BigDecimal getPricePerDayAdult() {
		return pricePerDayAdult;
	}
	public void setPricePerDayAdult(BigDecimal pricePerDayAdult) {
		this.pricePerDayAdult = pricePerDayAdult;
	}
	public BigDecimal getPricePerDayChild() {
		return pricePerDayChild;
	}
	public void setPricePerDayChild(BigDecimal pricePerDayChild) {
		this.pricePerDayChild = pricePerDayChild;
	}
	@Override
	public String toString() {
		return "PriceDetail [pricePerDayAdult=" + pricePerDayAdult + ", pricePerDayChild=" + pricePerDayChild + "]";
	}
	

	
}
