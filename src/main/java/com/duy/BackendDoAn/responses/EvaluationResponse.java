package com.duy.BackendDoAn.responses;

import com.duy.BackendDoAn.models.Evaluation;
import com.duy.BackendDoAn.models.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EvaluationResponse {
    @JsonProperty("rating")
    private Long rating;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("evaluation_date")
    private LocalDate evaluationDate;

    @JsonProperty("hotel_id")
    private Long hotel;

    @JsonProperty("user_id")
    private Long user;

    @JsonProperty("name")
    private String name;

    public static EvaluationResponse fromEvaluation(Evaluation evaluation) {
        return EvaluationResponse.builder()
                .rating(evaluation.getRating())
                .comment(evaluation.getComment())
                .evaluationDate(evaluation.getEvaluation_date())
                .hotel(evaluation.getHotel().getId())
                .user(evaluation.getUser().getId())
                .name(evaluation.getUser() != null ? evaluation.getUser().getName() : null)  // Đặt tên nếu có
                .build();
    }
}
