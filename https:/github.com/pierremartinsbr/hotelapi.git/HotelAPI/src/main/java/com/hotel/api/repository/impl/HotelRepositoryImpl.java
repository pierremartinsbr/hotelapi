package com.hotel.api.repository.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.hotel.api.model.Hotel;
import com.hotel.api.parameters.HotelParameter;
import com.hotel.api.repository.HotelRepository;

@Repository
public class HotelRepositoryImpl implements HotelRepository {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HotelRepositoryImpl.class);
	
	private static final RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public List<Hotel> findByCity(final HotelParameter hotelParameter) throws Exception {
		
		LOGGER.debug(">> CityCode: {} ", hotelParameter.getCityCode());
		
		try {
			
			final String url = "https://cvcbackendhotel.herokuapp.com/hotels/avail/{id}";
			
			Map<String, Integer> vars = new HashMap<String, Integer>();
			vars.put("id", hotelParameter.getCityCode());
			List<Hotel> hotels = Arrays.asList(restTemplate.getForObject(url, Hotel[].class, vars));
			
			return hotels;
			
		} catch (Exception e) {
			throw(e);
		}
		
	}

	@Override
	public Hotel getById(Integer id) throws Exception {
		
		LOGGER.debug(">> id: {} ", id);
		
		try {
			
			final String url = "https://cvcbackendhotel.herokuapp.com/hotels/{id}";
			
			Map<String, Integer> vars = new HashMap<String, Integer>();
			vars.put("id", id);
			Hotel[] response = restTemplate.getForObject(url, Hotel[].class, vars);
			
			Hotel hotel = Arrays.asList(response).get(0);
			
			return hotel;
			
		} catch (Exception e) {
			throw(e);
		}
		
	}

}
