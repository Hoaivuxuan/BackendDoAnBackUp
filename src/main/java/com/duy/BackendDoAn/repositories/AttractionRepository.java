package com.duy.BackendDoAn.repositories;

import com.duy.BackendDoAn.models.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AttractionRepository extends JpaRepository<Attraction, Long> {
    List<Attraction> findByCityIdAndType(Long cityId, String type);
}
