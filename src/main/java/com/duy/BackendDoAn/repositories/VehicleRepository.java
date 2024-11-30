package com.duy.BackendDoAn.repositories;

import com.duy.BackendDoAn.models.Vehicle;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query(value = "SELECT DISTINCT v FROM Vehicle v " +
            "LEFT JOIN FETCH v.vehicleRentalFacilities vrf " +  // JOIN FETCH để tránh LazyInitializationException
            "LEFT JOIN FETCH vrf.rentalFacility rf " +          // Liên kết với RentalFacility
            "LEFT JOIN FETCH rf.attraction a " +                // Liên kết với Attraction
            "LEFT JOIN FETCH a.city c " +                       // Liên kết với City
            "WHERE (:type IS NULL OR LOWER(v.vehicle_type) LIKE LOWER(CONCAT('%', :type, '%'))) " +  // LIKE với CONCAT
            "AND (:location IS NULL OR LOWER(c.city_name) LIKE LOWER(CONCAT('%', :location, '%'))) " + // Tìm kiếm không phân biệt hoa thường
            "AND v.id NOT IN (" +
            "    SELECT bv.vehicle.id FROM BookingVehicle bv " +
            "    WHERE bv.start_date < :endDate AND bv.return_date > :startDate " +
            "    AND bv.start_time < :endTime AND bv.return_time > :startTime" +
            ")")
    Page<Vehicle> searchVehicle(
            @Param("type") String type,
            @Param("location") String location,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("startTime") LocalTime startTime,
            @Param("endTime") LocalTime endTime,
            Pageable pageable
    );



}
