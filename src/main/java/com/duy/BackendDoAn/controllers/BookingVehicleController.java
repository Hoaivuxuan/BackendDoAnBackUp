package com.duy.BackendDoAn.controllers;

import com.duy.BackendDoAn.dtos.BookingVehicleDTO;
import com.duy.BackendDoAn.models.BookingVehicle;
import com.duy.BackendDoAn.responses.BookingVehicleResponse;
import com.duy.BackendDoAn.services.BookingVehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/bookingVehicle")
@RestController
public class BookingVehicleController {
    private final BookingVehicleService bookingVehicleService;
    @PostMapping
    public ResponseEntity<BookingVehicleResponse> createBooking(@Valid @RequestBody BookingVehicleDTO bookingVehicleDTO) throws Exception {
        BookingVehicle bookingVehicle = bookingVehicleService.createBooking(bookingVehicleDTO);
        BookingVehicleResponse bookingVehicleResponse = BookingVehicleResponse.fromBookingVehicle(bookingVehicle);
        return ResponseEntity.ok(bookingVehicleResponse);
    }
}
