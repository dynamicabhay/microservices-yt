package com.hotel.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.service.entity.Hotel;
import com.hotel.service.services.HotelService;

@RestController
@RequestMapping("/Hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@GetMapping
	public ResponseEntity<?> getAllHotels(){
		List<Hotel> hotels = hotelService.getAllHotels();
		return ResponseEntity.status(HttpStatus.OK).body(hotels);
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<?> getHotelById(@PathVariable String hotelId){
		Hotel hotel = hotelService.getHotelById(hotelId);
		return ResponseEntity.status(HttpStatus.OK).body(hotel);
		
	}
	
	@PostMapping
	public ResponseEntity<?> createHotel(@RequestBody Hotel hotel){
		Hotel hotel1 = hotelService.createHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
	}
}
