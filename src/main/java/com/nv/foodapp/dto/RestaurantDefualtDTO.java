package com.nv.foodapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDefualtDTO {
	private int restaurantId;
	private String restaurantName;
	private String restaurantContainItem;

}
