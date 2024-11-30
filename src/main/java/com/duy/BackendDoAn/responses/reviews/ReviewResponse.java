package com.duy.BackendDoAn.responses.reviews;

import com.duy.BackendDoAn.models.ReviewHotel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonProperty("review_date")
    private LocalDateTime reviewDate;

    @JsonProperty("reviewer_name")
    private String user;

    public static ReviewResponse fromReview(ReviewHotel reviewHotel) {
        ReviewResponse reviewResponse = ReviewResponse.builder()
                .rating(reviewHotel.getRating())
                .comment(reviewHotel.getComment())
                .reviewDate(reviewHotel.getReview_date())
                .user(reviewHotel.getUser().getName())
                .build();
        return reviewResponse;
    }
}
