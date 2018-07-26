package com.hotel.api.parameters;

import java.time.LocalDate;
import java.time.Period;

public class HotelParameter {
	
	private Integer cityCode;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private Integer adultAmount;
	private Integer childAmount;
	private Period period;
	
	public HotelParameter() {
		super();
	}
	
	public HotelParameter(Integer cityCode, LocalDate checkIn, LocalDate checkOut, Integer adultAmount,
			Integer childAmount) {
		super();
		this.cityCode = cityCode;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.adultAmount = adultAmount;
		this.childAmount = childAmount;
		this.period = Period.between(checkIn, checkOut);
	}

	public Integer getCityCode() {
		return cityCode;
	}

	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public Integer getAdultAmount() {
		return adultAmount;
	}

	public void setAdultAmount(Integer adultAmount) {
		this.adultAmount = adultAmount;
	}

	public Integer getChildAmount() {
		return childAmount;
	}

	public void setChildAmount(Integer childAmount) {
		this.childAmount = childAmount;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}
	
	
	
}
