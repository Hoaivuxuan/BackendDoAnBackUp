package com.duy.BackendDoAn.responses.vehicles;

import com.duy.BackendDoAn.models.Car;
import com.duy.BackendDoAn.models.Motor;
import com.duy.BackendDoAn.models.Vehicle;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailResponse {
    private String transmission;

    @JsonProperty("baggage_capacity")
    private Long baggageCapacity;

    private Long seats;
    private String fuel;
    private Long year;

    private Long engine;

    public static DetailResponse fromVehicle(Vehicle vehicle) {
        DetailResponse response = new DetailResponse();
        response.fuel = vehicle.getFuel_type();
        response.baggageCapacity = vehicle.getLuggage_amount();
        response.seats = vehicle.getSeat_amount();
        response.transmission = (Objects.equals(vehicle.getVehicle_type(), "CAR"))
                ? (((Car) vehicle)).getTransmission_type()
                : null;
        response.engine = (Objects.equals(vehicle.getVehicle_type(), "MOTOR"))
                ? ((Motor) vehicle).getEngine()
                : null;
        return response;
    }


}
