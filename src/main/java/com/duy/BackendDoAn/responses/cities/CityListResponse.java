package com.duy.BackendDoAn.responses.cities;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CityListResponse {
    private List<CityResponse> response;
    private int totalPages;
}
