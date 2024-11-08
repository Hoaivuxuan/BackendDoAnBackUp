package com.duy.BackendDoAn.repositories;

import com.duy.BackendDoAn.models.BookingVehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingVehicleRepository extends JpaRepository<BookingVehicle, Long> {
}
