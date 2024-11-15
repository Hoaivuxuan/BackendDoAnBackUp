package com.duy.BackendDoAn.responses.reviews;

import com.duy.BackendDoAn.models.ReviewHotel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewResponse {
    @JsonProperty("rating")
    private Long rating;

    @JsonProperty("comment")
    private String comment;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("review_date")
    private LocalDate reviewDate;

    @JsonProperty("reviewer_name")
    private String user;

    @JsonProperty("hotel_name")
    private String hotel;

    public static ReviewResponse fromReview(ReviewHotel reviewHotel) {
        ReviewResponse reviewResponse = ReviewResponse.builder()
                .rating(reviewHotel.getRating())
                .comment(reviewHotel.getComment())
                .reviewDate(reviewHotel.getReview_date())
                .user(reviewHotel.getUser().getName())
                .hotel(reviewHotel.getHotel().getHotelName())
                .build();
        return reviewResponse;
    }
}
