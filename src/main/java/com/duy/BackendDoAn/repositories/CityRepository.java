package com.duy.BackendDoAn.repositories;

import com.duy.BackendDoAn.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CityRepository extends JpaRepository<City, Long> {
    Page<City> findAll(Pageable pageable);
}
