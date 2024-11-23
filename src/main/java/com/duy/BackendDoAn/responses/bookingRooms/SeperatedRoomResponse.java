package com.duy.BackendDoAn.responses.bookingRooms;
import com.duy.BackendDoAn.models.BookedRoom;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeperatedRoomResponse {
    private String type;
    private Long count;
    private Float price;

    public static SeperatedRoomResponse fromBookedRoom(BookedRoom bookedRoom) {
        SeperatedRoomResponse response = new SeperatedRoomResponse();
        response.type = bookedRoom.getRoom().getType_of_room();
        response.count = bookedRoom.getAmount();
        response.price = bookedRoom.getPrice_per();
        return response;
    }
}
