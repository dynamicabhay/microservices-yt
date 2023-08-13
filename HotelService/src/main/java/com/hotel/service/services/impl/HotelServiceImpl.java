package com.hotel.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.service.entity.Hotel;
import com.hotel.service.exception.ResourceNotFoundException;
import com.hotel.service.repository.HotelRepository;
import com.hotel.service.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	

	@Autowired
	private HotelRepository dbHandler;

	@Override
	public List<Hotel> getAllHotels() {
		return dbHandler.findAll();
	}

	@Override
	public Hotel getHotelById(String id) {
		
		return dbHandler.findById(id).orElseThrow(() -> new ResourceNotFoundException("user with particular id doesn't exist") );
	}

	@Override
	public Hotel createHotel(Hotel hotel) {	
		String uuid = UUID.randomUUID().toString();
		hotel.setHotelId(uuid);
		return dbHandler.save(hotel);
	}

}
