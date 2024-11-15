package com.duy.BackendDoAn.controllers;

import com.duy.BackendDoAn.dtos.ReviewDTO;
import com.duy.BackendDoAn.models.ReviewHotel;
import com.duy.BackendDoAn.responses.reviews.ReviewResponse;
import com.duy.BackendDoAn.services.ReviewHotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/reviewHotel")
@RestController
public class ReviewHotelController {
    private final ReviewHotelService reviewHotelService;

    @PostMapping()
    public ResponseEntity<ReviewResponse> postNewReview(ReviewDTO reviewDTO) throws Exception {
        ReviewResponse reviewResponse = new ReviewResponse();
        ReviewHotel reviewHotel = reviewHotelService.postNewReview(reviewDTO);
        reviewResponse = ReviewResponse.fromReview(reviewHotel);
        return ResponseEntity.ok(reviewResponse);
    }

//    @DeleteMapping()
//    public ResponseEntity<ReviewResponse> deleteReview(@PathVariable long id) {
//        reviewHotelService.de
//    }
    
}
