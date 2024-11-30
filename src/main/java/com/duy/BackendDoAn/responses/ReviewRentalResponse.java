package com.duy.BackendDoAn.responses;

import com.duy.BackendDoAn.models.ReviewRentalFacility;
import com.duy.BackendDoAn.responses.reviews.ReviewResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewRentalResponse {
    @JsonProperty("rating")
    private Long rating;

    @JsonProperty("comment")
    private String comment;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonProperty("review_date")
    private LocalDateTime reviewDate;

    @JsonProperty("reviewer_name")
    private String user;

    public static ReviewRentalResponse fromReview(ReviewRentalFacility reviewRentalFacility) {
        ReviewRentalResponse reviewResponse = ReviewRentalResponse.builder()
                .rating(reviewRentalFacility.getRating())
                .comment(reviewRentalFacility.getComment())
                .reviewDate(reviewRentalFacility.getReview_date())
                .user(reviewRentalFacility.getUser().getName())
                .build();
        return reviewResponse;
    }
}
