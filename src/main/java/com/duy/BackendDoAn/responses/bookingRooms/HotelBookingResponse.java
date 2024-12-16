package com.duy.BackendDoAn.responses.bookingRooms;

import com.duy.BackendDoAn.models.BookingRoom;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelBookingResponse {
    private Long id;

    @JsonProperty("hotel_name")
    private String name;

    @JsonProperty("hotel_city")
    private String city;

    public static HotelBookingResponse fromBooking(BookingRoom bookingRoom) {
        return HotelBookingResponse.builder()
                .id(bookingRoom.getHotel().getId())
                .name(bookingRoom.getHotel().getHotelName())
                .city(bookingRoom.getHotel().getCity().getCity_name())
                .build();
    }
}
