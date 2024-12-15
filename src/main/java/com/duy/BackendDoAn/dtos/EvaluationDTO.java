package com.duy.BackendDoAn.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EvaluationDTO {
    @JsonProperty("rating")
    private Long rating;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("hotel_id")
    private Long hotel;
}
