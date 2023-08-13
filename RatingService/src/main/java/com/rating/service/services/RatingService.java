package com.rating.service.services;

import java.util.List;

import com.rating.service.entities.Rating;

public interface RatingService {

	// get All ratings 
	public List<Rating> getAllRatings();
	
	
	// get All ratings of hotel by id
	public List<Rating> getAllHotelsRating(String hotelId);
	
	// get All Ratings by userId
	public List<Rating> getAllRatingsByuserId(String userId);
	
	// get Rating by id
	public Rating getRatingById(String ratingId);
	
	// create Rating
	public Rating createRating(Rating rating);
	
}
