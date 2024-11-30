package com.duy.BackendDoAn.responses.rentalFacilities;

import com.duy.BackendDoAn.models.ReviewHotel;
import com.duy.BackendDoAn.models.ReviewRentalFacility;
import lombok.*;

import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserReviewResponse {
    private Long rating;

    private String user;

    private String date;

    private String comment;

    public static UserReviewResponse fromUserReview(ReviewRentalFacility reviewRentalFacility) {
        UserReviewResponse response = UserReviewResponse.builder()
                .rating(reviewRentalFacility.getRating())
                .user(reviewRentalFacility.getUser().getName())
                .date(reviewRentalFacility.getReview_date().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .comment(reviewRentalFacility.getComment())
                .build();
        return response;
    }
}
