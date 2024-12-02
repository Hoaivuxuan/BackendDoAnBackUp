package com.duy.BackendDoAn.controllers;

import com.duy.BackendDoAn.responses.cities.CityListResponse;
import com.duy.BackendDoAn.responses.cities.CityResponse;
import com.duy.BackendDoAn.services.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/city")
@RestController
public class CityController {
    private final CityService cityService;
    @GetMapping
    public ResponseEntity<CityListResponse> getAllCities(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit
    ) {

        PageRequest pageRequest =PageRequest.of(
                page, limit,
                Sort.by("id").ascending()
        );
        return ResponseEntity.ok(cityService.getAllCities(pageRequest));
    }
}
