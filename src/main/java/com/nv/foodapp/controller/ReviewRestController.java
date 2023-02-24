package com.nv.foodapp.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nv.foodapp.dto.ItemDTO;
import com.nv.foodapp.dto.ReviewResponseDTO;
import com.nv.foodapp.entity.Item;
import com.nv.foodapp.entity.Review;
import com.nv.foodapp.service.review.ReviewServiceImpl;
import com.nv.foodapp.util.ReviewDTOConvertor;

@RestController
@RequestMapping("/review")
@CrossOrigin(origins= {"http://localhost:4200","http://localhost:2022"},allowedHeaders = "*")
public class ReviewRestController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ReviewServiceImpl reviewServiceImpl;
	
	@Autowired
	ReviewDTOConvertor reviewConvertor;

	public ReviewRestController() {
		logger.info("---Review Controller called --");
		logger.warn("---Review Controller called --");

		System.out.println("Review Controller Called");
	}

	@GetMapping("/list")

	public List<Review> ListAllReviews() {

		return reviewServiceImpl.listAllReviews();
	}

	@PostMapping("/register")

	public Review addReview(@RequestBody Review review) {
		return reviewServiceImpl.addReview(review);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteReview(@PathVariable("id") Long id) {
		return reviewServiceImpl.deleteReview(id);
	}

	@GetMapping("restaurant/{id}")
	public List<Review> ListAllReviewsByRestaurantId(@PathVariable("id") Long id) {
		return reviewServiceImpl.listAllReviewsByRestaurantId(id);
	}
	
	@GetMapping("/avgreview/restaurantId/{restaurantId}")
	public int getAverageReviewByRestaurantId(@PathVariable int restaurantId){
		List<Review> allReviewsInDB = reviewServiceImpl.listAllReviews();
		
			int count=0;
			int avg=0;
			int totalreview=0;
			for(Review review : allReviewsInDB) {
				count++;
				totalreview +=review.getStarRating();
				
			}
			avg=totalreview/count;
			return avg;

		
		
	}
	

}
