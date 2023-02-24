package com.nv.foodapp.dto;

import lombok.Data;

@Data
public class ReviewResponseDTO {
	
	public String customerName;
	public int StarRating;
	public String message;

}
