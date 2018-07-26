package com.hotel.api.service;

import java.util.List;

import com.hotel.api.model.Hotel;
import com.hotel.api.parameters.HotelParameter;


public interface HotelService {
	
	public List<Hotel> findByCity(final HotelParameter hotelParameter) throws Exception;
	public Hotel getById(final Integer id) throws Exception;

}
