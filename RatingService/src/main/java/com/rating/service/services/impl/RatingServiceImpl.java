package com.rating.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.service.entities.Rating;
import com.rating.service.exception.ResourceNotFoundException;
import com.rating.service.repositories.RatingRepository;
import com.rating.service.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	private RatingRepository dbHandler;
	
	@Override
	public List<Rating> getAllRatings() {
		return dbHandler.findAll();
	}

	@Override
	public List<Rating> getAllHotelsRating(String hotelId) {
		return dbHandler.findByHotelId(hotelId);
	}

	@Override
	public List<Rating> getAllRatingsByuserId(String userId) {
		try {
		return dbHandler.findByUserId(userId);
		}catch(Exception e) {
			throw new ResourceNotFoundException("resource with the given id is not present");
		}
	}

	@Override
	public Rating getRatingById(String ratingId) {
		return dbHandler.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException("ratings are not present for given rating id"));
	}

	@Override
	public Rating createRating(Rating rating) {
		// TODO Auto-generated method stub
		String uuid = UUID.randomUUID().toString();
		rating.setRatingId(uuid);
		return dbHandler.save(rating);
		
	}

}
