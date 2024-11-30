package com.duy.BackendDoAn.controllers;

import com.duy.BackendDoAn.responses.AttractionResponse;
import com.duy.BackendDoAn.services.AttractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/attraction")
@RestController
public class AttractionController {
    private final AttractionService attractionService;
    @GetMapping
    public ResponseEntity<List<AttractionResponse>> getAllRentalByCity(
            @RequestParam Long city
    ){
        List<AttractionResponse> responses = attractionService.searchAllRental(city);
        return ResponseEntity.ok(responses);
    }

}
