package com.hotel.api.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.api.model.Hotel;
import com.hotel.api.parameters.HotelParameter;
import com.hotel.api.repository.HotelRepository;
import com.hotel.api.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HotelServiceImpl.class);
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public List<Hotel> findByCity(final HotelParameter hotelParameter) throws Exception {
		
		LOGGER.debug(">> hotelParameter: {} ", hotelParameter);
		
		List<Hotel> hotelList = hotelRepository.findByCity(hotelParameter);
		
		hotelList.stream().parallel().sequential()
				.forEach(hotel -> hotel.getRooms().forEach(room -> room.calcularViagem(hotelParameter.getPeriod())));
		
		return hotelList;
	}

	@Override
	public Hotel getById(Integer id) throws Exception {
		LOGGER.debug(">> id: {} ", id);
		
		return hotelRepository.getById(id);
	}

}
