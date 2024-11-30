package com.duy.BackendDoAn.responses.vehicles;

import com.duy.BackendDoAn.models.Vehicle;
import com.duy.BackendDoAn.models.VehicleRentalFacility;
import com.duy.BackendDoAn.responses.AttractionResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RentalResponse {

    @JsonProperty("id")
    private Long rentalId;
    private String name;
    private Float price;

    public static RentalResponse fromVehicle(VehicleRentalFacility vehicleRentalFacility) {
        RentalResponse response = new RentalResponse();
        response.rentalId = vehicleRentalFacility.getRentalFacility().getId();
        response.name = vehicleRentalFacility.getRentalFacility().getName();
        response.price = vehicleRentalFacility.getPrice();
        return response;
    }
}
