package com.duy.BackendDoAn.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingVehicleDTO {
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
    private List<AccessoryBookingDTO> accessoryBookings;
}
