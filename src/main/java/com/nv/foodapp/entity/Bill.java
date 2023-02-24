package com.nv.foodapp.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int billId;
	private String restaurantName;
	private int itemCount;
	private int grossBillAmount;
	private int gstAmount;


	public Bill(int itemCount,String restaurantName, int grossBillAmount, int gstAmount) {
		super();
		this.restaurantName=restaurantName;
		this.itemCount = itemCount;
		this.grossBillAmount = grossBillAmount;
		this.gstAmount = gstAmount;
	}

	

	
	
	
	
}
