package com.nv.foodapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nv.foodapp.dto.UserDTO;
import com.nv.foodapp.entity.User;
import com.nv.foodapp.service.user.IUserService;
import com.nv.foodapp.util.UserDTOConvertor;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	IUserService userService;

	@Autowired
	UserDTOConvertor dtoConvertor;

	public UserController() {
		//logger.info("User Controller Called");
		System.err.println("User Controller Called");

	}

	@PostMapping("/add")

	public ResponseEntity<UserDTO> saveUser(@RequestBody User user) throws Exception {

		User savedUser = userService.registerUser(user);
		//logger.info("----> User Saved <----" + savedUser);

		UserDTO dto = dtoConvertor.convertTo(savedUser);

		return new ResponseEntity<UserDTO>(dto, HttpStatus.OK);

	}

	@GetMapping("/list")
	public ResponseEntity<List<UserDTO>> getAllUsers() {

		List<User> allUsersInDB = userService.getAllUsers();

		List<UserDTO> dtoList = new ArrayList<>();
		for (User user : allUsersInDB) {

			UserDTO dto = dtoConvertor.convertTo(user);
			dtoList.add(dto);
		}

		return new ResponseEntity<List<UserDTO>>(dtoList, HttpStatus.OK);
	}

	@GetMapping("/userbycity/{city}")

	public ResponseEntity<List<UserDTO>> getUserByCity(@PathVariable String city) {

		List<User> allUsers = userService.getUserByCity(city);
		List<UserDTO> dto = new ArrayList<>();
		for(User user: allUsers) {
			UserDTO userDTO = dtoConvertor.convertTo(user);
			dto.add(userDTO);
		}

		return new ResponseEntity<List<UserDTO>>(dto, HttpStatus.OK);

	}

	@GetMapping("/userbystate/{state}")

	public ResponseEntity<List<UserDTO>> getUserByState(@PathVariable String state) {

		List<User> allUsers = userService.getUserByState(state);
		List<UserDTO> dtoObj= new ArrayList<>();
		for(User user: allUsers) {
			UserDTO userDTO = dtoConvertor.convertTo(user);
			dtoObj.add(userDTO);
		}

		return new ResponseEntity<List<UserDTO>>(dtoObj, HttpStatus.OK);
	
		
	}

	@GetMapping("/userbyid/{userId}")

	public ResponseEntity<UserDTO> getUserById(@PathVariable int userId) throws Exception {
		User userFromDB = userService.getUserById(userId);
		if (userFromDB != null) {
			UserDTO dto = dtoConvertor.convertTo(userFromDB);
			return new ResponseEntity<UserDTO>(dto, HttpStatus.OK);
		} else
			return null;
	}

	@PutMapping("/updateuser/{userId}")

	public String updatedUser(@PathVariable int userId) {

		User updatedUser = userService.getUserById(userId);
		return updatedUser.toString();
	}

}
