package com.hotel.api.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Period;

public class Room {
	
	private Integer roomID;
	private String categoryName;
	private BigDecimal totalPrice = new BigDecimal(0.0);
	private Price price;
	private PriceDetail priceDetail;
	
	public Room() {
		super();
	}
	
	public Room(Integer roomID, String categoryName, BigDecimal totalPrice, Price price, PriceDetail priceDetail) {
		super();
		this.roomID = roomID;
		this.categoryName = categoryName;
		this.totalPrice = totalPrice;
		this.price = price;
		this.priceDetail = priceDetail;
	}
	
	public void calcularViagem(final Period period) {
		BigDecimal multPeriod = new BigDecimal(period.getDays());
		BigDecimal comissao = new BigDecimal(0.7);
		this.priceDetail = new PriceDetail(this.price.getAdult().multiply(multPeriod).divide(comissao, RoundingMode.HALF_UP)
				, this.price.getChild().multiply(multPeriod).divide(comissao, RoundingMode.HALF_UP));
		this.totalPrice  = new BigDecimal(0.0).add(this.priceDetail.getPricePerDayAdult().add(this.priceDetail.getPricePerDayChild()));
	}
	
	public Integer getRoomID() {
		return roomID;
	}
	public void setRoomID(Integer roomID) {
		this.roomID = roomID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
	public PriceDetail getPriceDetail() {
		return priceDetail;
	}
	public void setPriceDetail(PriceDetail priceDetail) {
		this.priceDetail = priceDetail;
	}
	@Override
	public String toString() {
		return "Room [roomID=" + roomID + ", categoryName=" + categoryName + ", totalPrice=" + totalPrice + ", price="
				+ price + ", priceDetail=" + priceDetail + "]";
	}
	
	
}
