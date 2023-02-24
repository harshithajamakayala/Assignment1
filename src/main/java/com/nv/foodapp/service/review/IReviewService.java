package com.nv.foodapp.service.review;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nv.foodapp.entity.Item;
import com.nv.foodapp.entity.Restaurant;
import com.nv.foodapp.entity.Review;

@Service
public interface IReviewService {
	
	public Review addReview(Review review);
	public String deleteReview(Long id);
	public Review viewReviewById(Long id)throws Exception;
	public List<Review> listAllReviews();
	List<Review> listAllReviewsByRestaurantId(Long id);
	
	

}
