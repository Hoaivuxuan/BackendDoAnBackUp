package com.duy.BackendDoAn.responses;

import com.duy.BackendDoAn.models.AmenityForRoom;
import com.duy.BackendDoAn.models.*;
import com.duy.BackendDoAn.services.AmenityService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomResponse {

    @JsonProperty("price_per_day")
    private Float pricePerDay;

    @JsonProperty("description")
    private String description;

    @JsonProperty("available_room")
    private Long availableRoom;

    @JsonProperty("type_of_room")
    private String typeOfRoom;

    @JsonProperty("max_guests")
    private Long maxGuests;

    @JsonProperty("room_size")
    private Long roomSize;

    @JsonProperty("view")
    private String view;

    @JsonProperty("bed_type")
    private String typeOfBed;

    @JsonProperty("amenity_for_room")
    private List<String> amenityForRoom = new ArrayList<>();

    public static RoomResponse fromRoom(Room room){
        RoomResponse response = new RoomResponse();
        response.pricePerDay = room.getPrice_per_day();
        response.description = room.getDescription();
        response.availableRoom = room.getAvailable_room();
        response.typeOfRoom = room.getType_of_room();
        response.maxGuests = room.getMax_guests();
        response.roomSize = room.getRoom_size();
        response.view = room.getView();
        response.typeOfBed = room.getType_of_bed();
        response.amenityForRoom = (room.getAmenityForRooms() != null)
                ? room.getAmenityForRooms().stream()
                .map(amenityForRoom -> amenityForRoom.getAmenity().getName())
                .collect(Collectors.toList())
                : new ArrayList<>();
        return response;
    }
}
