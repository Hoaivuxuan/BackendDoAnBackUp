package com.duy.BackendDoAn.responses.bookingRooms;
import com.duy.BackendDoAn.models.BookedRoom;
import com.duy.BackendDoAn.models.BookingRoom;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingRoomResponse {
    private Long adults;
    private Long children;
    private Long hotel;

    @JsonProperty("checkin_date")
    private String checkInDate;

    @JsonProperty("checkout_date")
    private String checkOutDate;

    @JsonProperty("customerInfo")
    private CustomerResponse customerResponse;

    @JsonProperty("room_selection")
    private RoomSelectionResponse roomSelectionResponse;

    private Float totalPrice;

    public static BookingRoomResponse fromBooking(BookingRoom bookingRoom) {
        BookingRoomResponse response = new BookingRoomResponse();
        response.adults = bookingRoom.getAdults();
        response.children = bookingRoom.getChildren();
        response.hotel = bookingRoom.getHotel().getId();
        response.checkInDate = bookingRoom.getCheck_in_date().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        response.checkOutDate = bookingRoom.getCheck_out_date().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        response.roomSelectionResponse = (bookingRoom.getBookedRooms() != null)
                ? RoomSelectionResponse.fromBooking(bookingRoom)
                : new RoomSelectionResponse();
        response.customerResponse = (bookingRoom.getUser() != null)
                ? CustomerResponse.fromBookingCustomer(bookingRoom)
                : new CustomerResponse();
        response.totalPrice = bookingRoom.getTotal_price();
        return response;
    }
}
