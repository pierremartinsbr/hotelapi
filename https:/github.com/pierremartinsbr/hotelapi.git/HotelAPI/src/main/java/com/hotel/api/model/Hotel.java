package com.hotel.api.model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
	
	private Integer id;
	private String name;
	private Integer cityCode;
	private String cityName;
	private List<Room> rooms = new ArrayList<Room>();
	
	public Hotel() {
		super();
	}
	
	public Hotel(Integer id, String name, Integer cityCode, String cityName, List<Room> rooms) {
		super();
		this.id = id;
		this.name = name;
		this.cityCode = cityCode;
		this.cityName = cityName;
		this.rooms = rooms;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", cityCode=" + cityCode + ", cityName=" + cityName + ", rooms="
				+ rooms + "]";
	}
	
	

}
