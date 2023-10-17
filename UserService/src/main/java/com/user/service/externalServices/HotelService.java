package com.user.service.externalServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.service.entities.Hotel;

@FeignClient(name = "hotel-service")
public interface HotelService {

	@GetMapping("Hotels/{hotelId}")
	Hotel getHotel(@PathVariable String hotelId);
}
