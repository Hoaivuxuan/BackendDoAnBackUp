package com.duy.BackendDoAn.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotelDTO {
    @JsonProperty("hotel_name")
    private String hotelName;

    @JsonProperty("hotel_email")
    private String hotelEmail;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("address")
    private String address;

    @JsonProperty("longitude")
    private Float longitude;

    @JsonProperty("latitude")
    private Float latitude;

    @JsonProperty("check_in_time")
    private LocalTime checkInTime;

    @JsonProperty("check_out_time")
    private LocalTime checkOutTime;

    @JsonProperty("description")
    private String description;

    private String website;

    @JsonProperty("rating")
    private Float rating;

    @JsonProperty("city_id")
    private Long city;

    @JsonProperty("type_of_hotel")
    private String typeOfHotel;
}
