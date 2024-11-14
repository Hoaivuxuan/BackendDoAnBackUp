package com.duy.BackendDoAn.responses.hotels;

import com.duy.BackendDoAn.models.Hotel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationResponse {
    @JsonProperty("latitude")
    private Float latitude;

    @JsonProperty("longitude")
    private Float longitude;

    @JsonProperty("nearby_attractions")
    private List<NearbyAttractionResponse> nearbyAttractionResponses;

    public static LocationResponse fromLocation(Hotel hotel){
        LocationResponse response = new LocationResponse();
        response.latitude = hotel.getLatitude();
        response.longitude = hotel.getLongitude();
        response.nearbyAttractionResponses = hotel.getNearbyAttractions().stream().map(NearbyAttractionResponse::fromNearbyAttraction).collect(Collectors.toList());
        return response;
    }
}
