package com.duy.BackendDoAn.responses;

import com.duy.BackendDoAn.dtos.AccessoryBookingDTO;
import com.duy.BackendDoAn.models.AccessoryBooking;
import com.duy.BackendDoAn.models.BookingVehicle;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingVehicleResponse {
    private Long id;

    @JsonProperty("booking_date")
    private LocalDate bookingDate;

    @JsonProperty("start_date")
    private LocalDate startDate;

    @JsonProperty("start_time")
    private LocalTime startTime;

    @JsonProperty("start_address")
    private String startAddress;

    @JsonProperty("return_date")
    private LocalDate returnDate;

    @JsonProperty("return_time")
    private LocalTime returnTime;

    @JsonProperty("return_address")
    private String returnAddress;

    @JsonProperty("total_price")
    private Float totalPrice;

    @JsonProperty("vehicle_id")
    private Long vehicle;

    @JsonProperty("user_id")
    private Long user;

    @JsonProperty("accessory_booking")
    private List<AccessoryBooking> accessoryBookings;

    public static BookingVehicleResponse fromBookingVehicle(BookingVehicle bookingVehicle) {
        return BookingVehicleResponse.builder()
                .id(bookingVehicle.getId())
                .startDate(bookingVehicle.getStart_date())
                .startTime(bookingVehicle.getStart_time())
                .startAddress(bookingVehicle.getStart_address())
                .returnDate(bookingVehicle.getReturn_date())
                .returnTime(bookingVehicle.getReturn_time())
                .returnAddress(bookingVehicle.getReturn_address())
                .totalPrice(bookingVehicle.getTotal_price())
                .vehicle(bookingVehicle.getVehicle().getId())
                .user(bookingVehicle.getUser().getId())
                .accessoryBookings(bookingVehicle.getAccessoryBookings())
                .build();
    }
}
