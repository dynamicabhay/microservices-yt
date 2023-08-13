package com.rating.service.controller;


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

import com.rating.service.entities.Rating;
import com.rating.service.services.RatingService;

@RestController
@RequestMapping("/Ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping
	public ResponseEntity<?> createRating(@RequestBody Rating rating){
		Rating rt = ratingService.createRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(rt);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllRatings(){
		List<Rating> ratings = ratingService.getAllRatings();
		return ResponseEntity.ok().body(ratings);
	}
	
	@GetMapping("/Hotels/{hotelId}")
	public ResponseEntity<?> getHotelsById(@PathVariable String hotelId){
		List<Rating> ratings = ratingService.getAllHotelsRating(hotelId);
		return ResponseEntity.ok().body(ratings);
	}
	
	@GetMapping("/Users/{userId}")
	public ResponseEntity<?> getUsersById(@PathVariable String userId){
		List<Rating> ratings = ratingService.getAllRatingsByuserId(userId);
		return ResponseEntity.ok().body(ratings);
	}
	
	@GetMapping("/{ratingId}")
	public ResponseEntity<?> getRatingsById(@PathVariable String ratingId){
		Rating rating = ratingService.getRatingById(ratingId);
		return ResponseEntity.ok().body(rating);
	}
	
}
