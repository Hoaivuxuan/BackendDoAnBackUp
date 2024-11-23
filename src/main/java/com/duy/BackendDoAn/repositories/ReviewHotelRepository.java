package com.duy.BackendDoAn.repositories;

import com.duy.BackendDoAn.models.ReviewHotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewHotelRepository extends JpaRepository<ReviewHotel, Long> {
    boolean existsByUserIdAndHotelId(Long userId, Long hotelId);
}
