package com.duy.BackendDoAn.services;

import com.duy.BackendDoAn.models.City;
import com.duy.BackendDoAn.repositories.CityRepository;
import com.duy.BackendDoAn.responses.cities.CityListResponse;
import com.duy.BackendDoAn.responses.cities.CityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    public CityListResponse getAllCities(PageRequest pageRequest) {
        Page<City> cityPage = cityRepository.findAll(pageRequest);

        Page<CityResponse> responsesPage = cityPage.map(CityResponse::fromCity);
        List<CityResponse> responses = responsesPage.getContent();
        int totalPages = responsesPage.getTotalPages();


        return CityListResponse.builder()
                .response(responses)
                .totalPages(totalPages)
                .build();
    }


}
