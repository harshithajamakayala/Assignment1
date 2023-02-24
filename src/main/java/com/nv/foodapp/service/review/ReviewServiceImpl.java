package com.nv.foodapp.service.review;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nv.foodapp.entity.Item;
import com.nv.foodapp.entity.Restaurant;
import com.nv.foodapp.entity.Review;
import com.nv.foodapp.repository.restaurant.IRestaurantRepository;
import com.nv.foodapp.repository.review.IReviewRepository;

@Service
public class ReviewServiceImpl implements IReviewService {

	@Autowired
	private IReviewRepository reviewRepository;

	@Autowired
	IRestaurantRepository restaurantRepository;

	@Override
	public Review addReview(Review review) {
		// TODO Auto-generated method stub
		Review review1 = new Review();
		review1.setMessage(review.getMessage());
		review1.setCustomerName(review.getCustomerName());
		review1.setItemName(review.getItemName());
		review1.setRestaurantId(review.getRestaurantId());
		review1.setStarRating(review.getStarRating());
		review1.setTime_stamp(LocalDateTime.now());
		return reviewRepository.save(review1);
	}

	@Override
	public String deleteReview(Long id) {
		// TODO Auto-generated method stub
		reviewRepository.deleteById(id);

		return "Return deleted successfully";
	}

	@Override
	public List<Review> listAllReviews() {
		// TODO Auto-generated method stub
		List<Review> myList = reviewRepository.findAll();
		return myList;

	}

	@Override
	public List<Review> listAllReviewsByRestaurantId(Long id) {
		// TODO Auto-generated method stub
		List<Review> myList = reviewRepository.findAllByRestaurantId(id);
		return myList;
	}


	@Override
	public Review viewReviewById(Long id) throws Exception {
		// TODO Auto-generated method stub
		if (id >= 1) {
			Review savedReview = reviewRepository.getReferenceById(id);
			if (savedReview != null)
				return savedReview;
			else {
				throw new EntityNotFoundException("Invalid Item ID : " + id);
			}
		}
		return null;
	}

}
