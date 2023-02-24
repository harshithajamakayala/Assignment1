package com.nv.foodapp.dto;

import com.nv.foodapp.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	private int userId;
	private String firstName;
	private String lastName;
	private long phoneNumber;
	private String emailId;
	private Address address;
	



}
