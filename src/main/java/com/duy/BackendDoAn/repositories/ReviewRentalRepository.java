package com.duy.BackendDoAn.repositories;

import com.duy.BackendDoAn.models.ReviewRentalFacility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRentalRepository extends JpaRepository<ReviewRentalFacility, Long> {
    boolean existsByUserIdAndRentalFacilityId(Long userId, Long rentalFacilityId);

}
