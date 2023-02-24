package com.nv.foodapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
	
	private int itemId;
	private String itemName;
	private String category;
	private double cost;
	private String imageName;

}
