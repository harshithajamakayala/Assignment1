package com.nv.foodapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDTO {
	
	private int restaurantId;
	private String restaurantName;
	private String restaurantContactNumber;
	private String city;
	private String state;
	private String imageName;
	

}
