package com.duy.BackendDoAn.repositories;

import com.duy.BackendDoAn.models.Hotel;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @Query(
        "SELECT DISTINCT h FROM Hotel h " +
        "JOIN h.rooms r " +
        "JOIN h.city c " +
        "WHERE (:keyword IS NULL OR c.city_name LIKE %:keyword%) " +
        "GROUP BY h " +
        "HAVING COALESCE(SUM(r.available_room), 0) >= :noRooms"
    )
    Page<Hotel> searchHotels(
        @Param("keyword") String keyword,
        @Param("noRooms") int noRooms,
        Pageable pageable
    );
}
