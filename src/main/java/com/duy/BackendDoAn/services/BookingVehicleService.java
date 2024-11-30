package com.duy.BackendDoAn.services;

import com.duy.BackendDoAn.dtos.AccessoryBookingDTO;
import com.duy.BackendDoAn.dtos.BookingVehicleDTO;
import com.duy.BackendDoAn.models.*;
import com.duy.BackendDoAn.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingVehicleService {
    private final BookingVehicleRepository bookingVehicleRepository;
    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;
    private final VehicleRentalFacilityRepository vehicleRentalFacilityRepository;
    private final AccessoryRepository accessoryRepository;
    private final AccessoryBookingRepository accessoryBookingRepository;
    private final RentalFacilityRepository rentalFacilityRepository;
    public BookingVehicle createBooking(BookingVehicleDTO bookingVehicleDTO) throws Exception {
        Vehicle vehicle = vehicleRepository.findById(bookingVehicleDTO.getVehicle()).orElseThrow(()-> new Exception("Vehicle not found"));
        RentalFacility rentalFacility = rentalFacilityRepository.findById(bookingVehicleDTO.getRental()).orElseThrow(()-> new Exception("Rental Facility not found"));
        VehicleRentalFacility vehicleRentalFacility = vehicleRentalFacilityRepository
                .findByVehicleAndRentalFacility(vehicle, rentalFacility)
                .orElseThrow(() -> new Exception("VehicleRentalFacility not found"));

        User user = userRepository.findById(bookingVehicleDTO.getUser()).orElseThrow(()-> new Exception("User not found"));
        BookingVehicle bookingVehicle = BookingVehicle.builder()
                .booking_date(LocalDate.now())
                .start_date(bookingVehicleDTO.getStartDate())
                .start_time(bookingVehicleDTO.getStartTime())
                .start_address(bookingVehicleDTO.getStartAddress())
                .return_date(bookingVehicleDTO.getReturnDate())
                .return_time(bookingVehicleDTO.getReturnTime())
                .return_address(bookingVehicleDTO.getReturnAddress())
                .vehicle(vehicle)
                .user(user)
                .build();
        Float total = 0F;

        LocalDateTime startDateTime = LocalDateTime.of(bookingVehicle.getStart_date(), bookingVehicle.getStart_time());
        LocalDateTime returnDateTime = LocalDateTime.of(bookingVehicle.getReturn_date(), bookingVehicle.getReturn_time());
        total += vehicleRentalFacility.getPrice() * ChronoUnit.HOURS.between(startDateTime, returnDateTime);

        List<AccessoryBooking> accessoryBookingList = new ArrayList<>();
        for(AccessoryBookingDTO accessoryBookingDTO: bookingVehicleDTO.getAccessoryBookings()){
            Accessory accessory = accessoryRepository.findById(accessoryBookingDTO.getAccessory()).orElseThrow(()-> new Exception("Accesssory not found"));
            AccessoryBooking accessoryBooking = AccessoryBooking.builder()
                    .price_per(accessory.getPrice())
                    .accessory(accessory)
                    .bookingVehicle(bookingVehicle)
                    .build();
            total += accessoryBooking.getPrice_per();
            accessoryBookingList.add(accessoryBooking);
        }
        bookingVehicle.setTotal_price(total);
        bookingVehicle.setAccessoryBookings(accessoryBookingList);
        bookingVehicleRepository.save(bookingVehicle);
        accessoryBookingRepository.saveAll(accessoryBookingList);
        return bookingVehicle;
    }
}
