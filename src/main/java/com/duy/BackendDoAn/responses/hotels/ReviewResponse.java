package com.duy.BackendDoAn.responses.hotels;

import com.duy.BackendDoAn.models.Hotel;
import com.duy.BackendDoAn.models.ReviewHotel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewResponse {
    @JsonProperty("total_reviews")
    private Long totalReviews;

    @JsonProperty("average_rating")
    private Float averageRating;

    @JsonProperty("review_breakdown")
    private Map<String, Long> reviewBreakdown;

    @JsonProperty("recent_reviews")
    private List<UserReviewResponse> userReviewResponses;

    public static ReviewResponse fromReviews(Hotel hotel){
        ReviewResponse response = new ReviewResponse();
        response.totalReviews = (long) hotel.getReviews().size();
        response.averageRating = hotel.getRating();

        List<ReviewHotel> reviews = hotel.getReviews();
        Map<String, Long> reviewBreakdown = new HashMap<>();
        reviewBreakdown.put("5_star", reviews.stream().filter(r -> r.getRating() == 5).count());
        reviewBreakdown.put("4_star", reviews.stream().filter(r -> r.getRating() == 4).count());
        reviewBreakdown.put("3_star", reviews.stream().filter(r -> r.getRating() == 3).count());
        reviewBreakdown.put("2_star", reviews.stream().filter(r -> r.getRating() == 2).count());
        reviewBreakdown.put("1_star", reviews.stream().filter(r -> r.getRating() == 1).count());
        response.reviewBreakdown = reviewBreakdown;

        response.userReviewResponses = reviews.stream().map(UserReviewResponse::fromUserReview).collect(Collectors.toList());
        return response;
    }
}
