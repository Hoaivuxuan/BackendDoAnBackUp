package com.duy.BackendDoAn.responses.hotels;

import com.duy.BackendDoAn.models.ReviewHotel;
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

    public static UserReviewResponse fromUserReview(ReviewHotel reviewHotel) {
        UserReviewResponse response = UserReviewResponse.builder()
                .rating(reviewHotel.getRating())
                .user(reviewHotel.getUser().getName())
                .date(reviewHotel.getReview_date().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                .comment(reviewHotel.getComment())
                .build();
        return response;
    }
}
