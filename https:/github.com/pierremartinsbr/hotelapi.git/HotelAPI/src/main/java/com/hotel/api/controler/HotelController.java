package com.hotel.api.controler;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.api.model.Hotel;
import com.hotel.api.parameters.HotelParameter;
import com.hotel.api.service.HotelService;

@RestController
@RequestMapping("/api/v1")
@Validated
public class HotelController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HotelController.class);
	
	@Autowired
	private HotelService hotelService;
	
	@RequestMapping(method=RequestMethod.GET, value="/hotels")
    public ResponseEntity<List<Hotel>> findByCity(@RequestParam(value="cityCode", required=true) Integer cityCode
    		,@RequestParam(value="checkIn", required=true) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate checkIn
    		,@RequestParam(value="checkOut", required=true) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate checkOut
    		,@RequestParam(value="adultAmount", required=true) Integer adultAmount
    		,@RequestParam(value="childAmount", required=true) Integer childAmount) {
		
		LOGGER.info(">> cityCode: {} checkIn: {} checkOut: {} adultAmount: {} childAmount: {}", cityCode, checkIn,
				checkOut, adultAmount, childAmount);
		
        try {
        	
        	HotelParameter parameter = new HotelParameter(cityCode, checkIn, checkOut, adultAmount, childAmount);
			
        	return Optional.ofNullable( hotelService.findByCity(parameter) )
                    .map( listHotel -> ResponseEntity.ok().body(listHotel) )          
                    .orElseGet( () -> ResponseEntity.notFound().build() );
        	
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
    }
	
	@RequestMapping(method=RequestMethod.GET, value="/hotels/{id}")
    public ResponseEntity<Hotel> getById(@PathVariable(value="id", required=true) Integer id) {
		
		LOGGER.info(">> id: {} ", id);
		
        try {
        	return Optional.ofNullable( hotelService.getById(id) )
                    .map( hotel -> ResponseEntity.ok().body(hotel) )          
                    .orElseGet( () -> ResponseEntity.notFound().build() );
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
    }
	
	@RequestMapping(method=RequestMethod.GET, value="/health")
    public ResponseEntity<Object> healthCheck() {
		
		LOGGER.info(">> healthCheck");
		
        return ResponseEntity.ok("Health");
    }

}
