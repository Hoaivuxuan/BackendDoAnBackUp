package com.duy.BackendDoAn.responses.bookingRooms;

import com.duy.BackendDoAn.models.BookingRoom;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponse {
    private String country;
    private String email;

    @JsonProperty("fullname")
    private String fullName;
    private String phone;

    public static CustomerResponse fromBookingCustomer(BookingRoom bookingRoom) {
        CustomerResponse response = CustomerResponse.builder()
                .country(bookingRoom.getUser().getCountry())
                .email(bookingRoom.getUser().getEmail())
                .fullName((bookingRoom.getUser() != null && bookingRoom.getUser().getFirst_name() != null && bookingRoom.getUser().getLast_name() != null)
                        ? bookingRoom.getUser().getFirst_name() + " " + bookingRoom.getUser().getLast_name()
                        : null)
                .phone(bookingRoom.getUser().getPhone_number())
                .build();
        return response;
    }
}