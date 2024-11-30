package com.duy.BackendDoAn.services;

import com.duy.BackendDoAn.models.Attraction;
import com.duy.BackendDoAn.repositories.AttractionRepository;
import com.duy.BackendDoAn.responses.AttractionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttractionService {

    private final AttractionRepository attractionRepository;
    public List<AttractionResponse> searchAllRental(Long city) {
        List<Attraction> result = attractionRepository.findByCityIdAndType(city, "RENTAL");
        return result.stream().map(AttractionResponse::fromAttraction).collect(Collectors.toList());
    }
}
