package com.nv.foodapp.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity 
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private LocalDateTime time_stamp;
	private String message;
	private String itemName;
	private String customerName;
	private int restaurantId;
	private int starRating;
	
	public Review(LocalDateTime time_stamp, String message, String itemName, String customerName, int restaurantId,
			int starRating) {
		super();
		this.time_stamp = time_stamp;
		this.message = message;
		this.itemName = itemName;
		this.customerName = customerName;
		this.restaurantId = restaurantId;
		this.starRating = starRating;
	}
	
	
	

}
