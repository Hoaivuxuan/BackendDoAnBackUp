package com.duy.BackendDoAn.responses;

import com.duy.BackendDoAn.models.Attraction;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttractionResponse {
    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    private String type;
    private String image;

    @JsonProperty("city_name")
    private Long city;

    public static AttractionResponse fromAttraction(Attraction attraction) {
        AttractionResponse response = AttractionResponse.builder()
                .name(attraction.getName())
                .description(attraction.getDescription())
                .type(attraction.getType())
                .image(attraction.getImage())
                .city(attraction.getCity().getId())
                .build();
        return response;
    }
}
