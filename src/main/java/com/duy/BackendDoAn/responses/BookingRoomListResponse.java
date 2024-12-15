package com.duy.BackendDoAn.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class BookingRoomListResponse {
    private List<BookingRoomResponse> bookingRoom;
    private int totalPages;
}
