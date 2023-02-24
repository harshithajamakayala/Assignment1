package com.nv.foodapp.entity;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	private String buildingName;
	private String area;
	private String streetNo;
	private String city;
	private String state;
	private String country;
	private String pincode;

}
