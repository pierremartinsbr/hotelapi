package com.hotel.api.model;

import java.math.BigDecimal;

public class Price {
	
	private BigDecimal adult;
	private BigDecimal child;
	
	public Price() {
		super();
	}
	
	public Price(BigDecimal adult, BigDecimal child) {
		super();
		this.adult = adult;
		this.child = child;
	}
	
	public BigDecimal getAdult() {
		return adult;
	}
	public void setAdult(BigDecimal adult) {
		this.adult = adult;
	}
	public BigDecimal getChild() {
		return child;
	}
	public void setChild(BigDecimal child) {
		this.child = child;
	}
	@Override
	public String toString() {
		return "Price [adult=" + adult + ", child=" + child + "]";
	}
	
	
	

}
