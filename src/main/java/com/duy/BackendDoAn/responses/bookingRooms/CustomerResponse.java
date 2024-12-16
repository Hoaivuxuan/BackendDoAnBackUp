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
                .country(bookingRoom.getCustomerCountry())
                .email(bookingRoom.getCustomerEmail())
                .fullName(bookingRoom.getCustomerFullName())
                .phone(bookingRoom.getCustomerPhoneNumber())
                .build();
        return response;
    }
}
