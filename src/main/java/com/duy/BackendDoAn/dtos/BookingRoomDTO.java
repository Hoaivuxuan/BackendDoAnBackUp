package com.duy.BackendDoAn.dtos;

import com.duy.BackendDoAn.models.BookedRoom;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingRoomDTO {
    @JsonProperty("user_id")
    private Long user;

    private Long adults;
    private Long children;

    @JsonProperty("check_in_date")
    private LocalDate checkInDate;

    @JsonProperty("check_out_date")
    private LocalDate checkOutDate;

    @JsonProperty("total_price")
    private Float totalPrice;

    @JsonProperty("full_name")
    private String customerFullName;

    @JsonProperty("email")
    private String customerEmail;

    @JsonProperty("phone")
    private String customerPhoneNumber;

    @JsonProperty("country")
    private String customerCountry;

    @JsonProperty("status")
    private String status;

    @JsonProperty("special_request")
    private String specialRequest;

    @JsonProperty("arrival_time")
    private String arrivalTime;

    @JsonProperty("booked_rooms")
    private List<BookedRoomDTO> bookedRooms;
}
