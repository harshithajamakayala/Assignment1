package com.nv.foodapp.repository.restaurant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nv.foodapp.entity.Restaurant;
import com.nv.foodapp.entity.Review;

@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant,Integer>{

	@Query(value = "SELECT * from restaurant where restaurant_id=?1", nativeQuery = true)
	public List<Restaurant> findAllByRestaurantId(int id);
	
	@Query(value = "SELECT * from restaurant where  restaurant_name=?", nativeQuery = true)
   public List<Restaurant> findAllByRestaurantName(String name);

	
}
