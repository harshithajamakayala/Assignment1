package com.nv.foodapp.util;

import org.springframework.stereotype.Component;

import com.nv.foodapp.dto.UserDTO;
import com.nv.foodapp.entity.User;
import com.nv.foodapp.entity.Address;

@Component
public class UserDTOConvertor {
	public UserDTO convertTo(User user) {
      
		UserDTO obj= new UserDTO(user.getUserId(), user.getFirstName(), user.getLastName(), user.getPhoneNumber(),user.getEmailId(),
				user.getAddress());
		
		return obj;
	}
	
}
