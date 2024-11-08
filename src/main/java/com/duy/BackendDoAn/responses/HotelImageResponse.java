package com.duy.BackendDoAn.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelImageResponse {
    @JsonProperty("hotel_id")
    private Long hotel;

    @JsonProperty("image_url")
    private String imageUrl;
}
