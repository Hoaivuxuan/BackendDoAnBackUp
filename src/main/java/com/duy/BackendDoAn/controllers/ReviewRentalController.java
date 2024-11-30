package com.duy.BackendDoAn.controllers;

import com.duy.BackendDoAn.dtos.ReviewDTO;
import com.duy.BackendDoAn.models.ReviewRentalFacility;
import com.duy.BackendDoAn.responses.ReviewRentalResponse;
import com.duy.BackendDoAn.services.ReviewRentalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/reviewRental")
@RestController
public class ReviewRentalController {
    private final ReviewRentalService reviewRentalService;
    @PostMapping
    public ResponseEntity<ReviewRentalResponse> postNewReview(@Valid @RequestBody ReviewDTO reviewDTO) {
        ReviewRentalResponse reviewRentalResponse = new ReviewRentalResponse();
        ReviewRentalFacility reviewRentalFacility = reviewRentalService.postNewReview(reviewDTO);
        reviewRentalResponse = ReviewRentalResponse.fromReview(reviewRentalFacility);
        return ResponseEntity.ok(reviewRentalResponse);
    }
}
