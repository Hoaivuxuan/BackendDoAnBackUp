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

    private Float longitude;
    private Float latitude;

    private String type;
    private String image;

    @JsonProperty("city_name")
    private String city;

    public static AttractionResponse fromAttraction(Attraction attraction) {
        AttractionResponse response = AttractionResponse.builder()
                .name(attraction.getName())
                .latitude(attraction.getLatitude())
                .longitude(attraction.getLongitude())
                .type(attraction.getType())
                .image(attraction.getImage())
                .city(attraction.getCity().getCity_name())
                .build();
        return response;
    }
}
