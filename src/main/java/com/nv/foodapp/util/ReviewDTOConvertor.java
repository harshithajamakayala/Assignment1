package com.nv.foodapp.util;

import org.springframework.stereotype.Component;

import com.nv.foodapp.dto.ReviewResponseDTO;
import com.nv.foodapp.entity.Review;

@Component
public class ReviewDTOConvertor {
	
	public ReviewResponseDTO getReviewResponseDTO(Review review)
	{
		ReviewResponseDTO dto = new ReviewResponseDTO();
		dto.setCustomerName(review.getCustomerName());
		dto.setStarRating(review.getStarRating());
		dto.setMessage("Review saved");
		return dto;
		
		
	}

}
