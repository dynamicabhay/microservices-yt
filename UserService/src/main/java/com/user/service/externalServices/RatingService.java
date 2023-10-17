package com.user.service.externalServices;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.service.entities.Rating;

@FeignClient(name="rating-service")
public interface RatingService {
	
	@GetMapping("Ratings/Users/{ratingId}")
	List<Rating> getRatings(@PathVariable String ratingId);

}
