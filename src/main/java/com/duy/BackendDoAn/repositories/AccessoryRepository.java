package com.duy.BackendDoAn.repositories;

import com.duy.BackendDoAn.models.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccessoryRepository extends JpaRepository<Accessory, Long> {
    List<Accessory> findByType(String type);
}
