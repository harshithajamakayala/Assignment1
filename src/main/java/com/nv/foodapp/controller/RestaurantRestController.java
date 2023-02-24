package com.nv.foodapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nv.foodapp.dto.RestaurantDTO;
import com.nv.foodapp.dto.RestaurantRequestDTO;
import com.nv.foodapp.entity.Restaurant;
import com.nv.foodapp.entity.Review;
import com.nv.foodapp.service.restaurant.IRestaurantService;
import com.nv.foodapp.util.RestaurantDTOConvertor;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin(origins= {"http://localhost:4200","http://localhost:2022"},allowedHeaders = "*")
public class RestaurantRestController {

	@Autowired
	RestaurantDTOConvertor restuarantConvertor;
	@Autowired
	IRestaurantService restaurantService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public RestaurantRestController() {
		logger.info("restaurant rest controller");
		System.err.println("restaurant rest controller");
	}

	@PostMapping("/register")
	public ResponseEntity<RestaurantDTO> savedRestaurants(@RequestBody RestaurantRequestDTO restaurantDto) throws Exception {
		//code to convert restaurant request Dto to restaurant
		Restaurant restaurant=restuarantConvertor.getRestaurantRequestDTO(restaurantDto);
		Restaurant savedRestaurant = restaurantService.addRestaurant(restaurant);
		logger.info(" --->> Instructor saved " + savedRestaurant);

		if (savedRestaurant != null) {
			RestaurantDTO dtoObj = restuarantConvertor.getRestaurantDTO(savedRestaurant);
			return new ResponseEntity<RestaurantDTO>(dtoObj, HttpStatus.OK);

		}
		return null;
	}

	@GetMapping("/list")
	public ResponseEntity<List<RestaurantDTO>> getAllRestuarant() {
		List<Restaurant> allRestuarant = restaurantService.viewAllRestaurants();
		List<RestaurantDTO> restuarantDtoList = new ArrayList<>();

		if (allRestuarant != null && allRestuarant.isEmpty() == false) {
			for (Restaurant restuarants : allRestuarant) {
				RestaurantDTO dto = restuarantConvertor.getRestaurantDTO(restuarants);
				restuarantDtoList.add(dto);
			}
		}

		return new ResponseEntity<List<RestaurantDTO>>(restuarantDtoList, HttpStatus.OK);
	}

	@GetMapping("/{resid}")
	public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable int resid) throws Exception {

		Restaurant savedRestaurant = restaurantService.viewRestaurantById(resid);
		RestaurantDTO dto = restuarantConvertor.getRestaurantDTO(savedRestaurant);
		return new ResponseEntity<RestaurantDTO>(dto, HttpStatus.OK);

	}

	@DeleteMapping("/remove/{restaurantId}")
	public ResponseEntity<Boolean> deleteRestaurant(@PathVariable int restaurantId) {
		boolean status = restaurantService.removeRestaurant(restaurantId);
		return new ResponseEntity<Boolean>(status, HttpStatus.OK);
	}

	@GetMapping("restaurantId/{id}")
	public List<Restaurant> ListAllByRestaurantId(@PathVariable("id") int id) {
		return restaurantService.findAllByRestaurantId(id);
	}

	@GetMapping("/resbystate/{state}")

	public ResponseEntity<List<RestaurantDTO>> getResByState(@PathVariable String state) {

		List<Restaurant> allRes = restaurantService.getRestuarantByState(state);
		List<RestaurantDTO> dtoObj = new ArrayList<>();
		for (Restaurant res : allRes) {
			RestaurantDTO resDTO = restuarantConvertor.getRestaurantDTO(res);
			dtoObj.add(resDTO);
		}

		return new ResponseEntity<List<RestaurantDTO>>(dtoObj, HttpStatus.OK);

	}
	@GetMapping("/resbycity/{city}")

	public ResponseEntity<List<RestaurantDTO>> getResByCity(@PathVariable String city) {

		List<Restaurant> allRes = restaurantService.getRestuarantByCity(city);
		List<RestaurantDTO> dtoObj = new ArrayList<>();
		for (Restaurant res : allRes) {
			RestaurantDTO resDTO = restuarantConvertor.getRestaurantDTO(res);
			dtoObj.add(resDTO);
		}

		return new ResponseEntity<List<RestaurantDTO>>(dtoObj, HttpStatus.OK);

	}
	@GetMapping("/resbyname/{name}")

	public ResponseEntity<List<RestaurantDTO>> getResByName(@PathVariable String name) {

		List<Restaurant> allRes = restaurantService.getRestuarantByName(name);
		List<RestaurantDTO> dtoObj = new ArrayList<>();
		for (Restaurant res : allRes) {
			RestaurantDTO resDTO = restuarantConvertor.getRestaurantDTO(res);
			dtoObj.add(resDTO);
		}

		return new ResponseEntity<List<RestaurantDTO>>(dtoObj, HttpStatus.OK);

	}
	@GetMapping("restaurantName/{name}")
	public List<Restaurant> ListAllByRestaurantName(@PathVariable("name") String name) {
		return restaurantService.findAllByRestaurantName(name);
	}

}
