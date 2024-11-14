package com.duy.BackendDoAn.services;

import com.duy.BackendDoAn.models.Amenity;
import com.duy.BackendDoAn.repositories.AmenityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AmenityService {
    public final AmenityRepository amenityRepository;

    public List<Amenity> getAllAmenities() {
        return amenityRepository.findAll();
    }

    public Optional<Amenity> getAmenityById(long id) {
        return amenityRepository.findById(id);
    }
}
