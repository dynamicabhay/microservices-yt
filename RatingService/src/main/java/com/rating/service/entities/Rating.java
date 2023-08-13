package com.rating.service.entities;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Ratings")
public class Rating {

	@Id
	@Column(name="id")
	private String ratingId;
	
	private String userId;
	private String hotelId;
	private String rating;
	private String feedback;
}
