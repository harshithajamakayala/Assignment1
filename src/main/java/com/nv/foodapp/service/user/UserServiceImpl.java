package com.nv.foodapp.service.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nv.foodapp.entity.User;
import com.nv.foodapp.exception.InvalidInputDataException;
import com.nv.foodapp.repository.user.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository userRepository;

	@Override
	public User registerUser(User user) throws Exception {
		// TODO Auto-generated method stub
		if(user.getFirstName().equals("") || user.getLastName().equals("")) {
			throw new InvalidInputDataException("User name","First Name or Last Name is null");
		}
		
		if(user.getEmailId().equals("")) {
			throw new InvalidInputDataException("Email Id","Email Id cannot be null");
		}
		if(user.getPassword().equals("")) {
			throw new InvalidInputDataException("Password","Password cannot be null");
		}
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		User userFromDB = userRepository.getReferenceById(userId);
		userRepository.getReferenceById(userId);
	
		return userFromDB;
	}

	@Override
	public User updateUser(int userId) {
		// TODO Auto-generated method stub
		User updatedUser = userRepository.getReferenceById(userId);
		userRepository.save(updatedUser);
		return updatedUser;
	}

	@Override
	public List<User> getUserByState(String state) {
		// TODO Auto-generated method stub
		List<User> allUsers = userRepository.findAll();
		List<User> allUserByState = new ArrayList<>();
		for (User user: allUsers) {
			String userState = user.getAddress().getState();
			if(userState.equals(state)) {
				allUserByState.add(user);
			}
		}
		return allUserByState;
	}

	@Override
	public List<User> getUserByCity(String city) {
		// TODO Auto-generated method stub
		List<User> allUsers = userRepository.findAll();
		//Filter user through for loop based on city
		List<User> allUserByCity = new ArrayList<>();
		for(User user : allUsers) {
			String userCity =user.getAddress().getCity();
		if(userCity.equals(city)) {
			allUserByCity.add(user);
		}
		}
		
		return allUserByCity;
	}

}
