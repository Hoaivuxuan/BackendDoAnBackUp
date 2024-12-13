package com.duy.BackendDoAn.responses.cities;

import com.duy.BackendDoAn.models.City;
import com.duy.BackendDoAn.repositories.CityRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CityResponse {
    private Long id;
    private String name;
    private String type;

    @JsonProperty("parent_name")
    private String parent;


    public static CityResponse fromCity(City city) {
        if (city == null) return null;

        return new CityResponse(
                city.getId(),
                city.getCity_name(),
                city.getType(),
                city.getParent() != null ? city.getParent().getCity_name() : null
        );
    }
}
