package com.nv.foodapp.util;

import org.springframework.stereotype.Component;

import com.nv.foodapp.dto.RestaurantDTO;
import com.nv.foodapp.dto.RestaurantDefualtDTO;
import com.nv.foodapp.dto.RestaurantRequestDTO;
import com.nv.foodapp.entity.Address;
import com.nv.foodapp.entity.Restaurant;

@Component
public class RestaurantDTOConvertor {
	
	public RestaurantDTO getRestaurantDTO(Restaurant r)
	{
		RestaurantDTO obj= new RestaurantDTO(r.getRestaurantId(),r.getRestaurantName(),r.getContactNumber(),r.getAddress().getCity(),r.getAddress().getState(),r.getImageName());
		
	    return obj;
	}
	
	
	public  Restaurant  getRestaurantRequestDTO(RestaurantRequestDTO r) {
	
		//public Restaurant(String restaurantName, String managerName, String contactNumber, Address address)
	     
		Address a=new Address(r.getBuildingName(),r.getArea(),r.getStreetNo(),r.getCity(),r.getState(),r.getCountry(),r.getPincode());
		Restaurant obj=new Restaurant(r.getRestaurantName(),r.getManagerName(),r.getContactNumber(), a,r.getImageName());
		
		return obj;
	
	}
	
	
	
	

}
