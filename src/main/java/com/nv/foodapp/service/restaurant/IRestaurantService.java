package com.nv.foodapp.service.restaurant;

import java.util.List;

import org.springframework.stereotype.Service;
import com.nv.foodapp.entity.Restaurant;

@Service
public interface IRestaurantService {
	public Restaurant addRestaurant(Restaurant res)throws Exception;
	public boolean removeRestaurant(int restaurantId);
	public Restaurant viewRestaurantById(int id);
	public List<Restaurant> viewAllRestaurants();
	public List<Restaurant> findAllByRestaurantId(int id);
	public List<Restaurant> findAllByRestaurantName(String name);
	public List<Restaurant> getRestuarantByState(String state);
	public List<Restaurant> getRestuarantByCity(String city);
	public List<Restaurant> getRestuarantByName(String name);
	
	
}
