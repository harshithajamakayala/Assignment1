package com.nv.foodapp.dto;

import java.util.List;

import com.nv.foodapp.entity.Item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillDTO {

	private int billId;
	private String restaurantName;
	private int itemCount;
	private int totalAmount;
	private int gstAmount;
	
}   
