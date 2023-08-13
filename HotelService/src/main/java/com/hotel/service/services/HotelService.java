package com.hotel.service.services;

import java.util.List;

import com.hotel.service.entity.Hotel;

public interface HotelService {

	public List<Hotel> getAllHotels();
	public Hotel getHotelById(String id);
	public Hotel createHotel(Hotel hotel);
}

