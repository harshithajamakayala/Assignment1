package com.nv.foodapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantRequestDTO {
	private int restaurantId;
    private String restaurantName;
    private String managerName;
	private String contactNumber;
	private String buildingName;
	private String area;
	private String streetNo;
	private String city;
	private String state;
	private String country;
	private String pincode;
	private String imageName;

}

// create class properly 