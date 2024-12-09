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

    private String engine;
    private String brand;
    private String capacity;

    public static DetailResponse fromVehicle(Vehicle vehicle) {
        DetailResponse response = new DetailResponse();
        response.fuel = vehicle.getFuel();
        response.brand = vehicle.getBrand();
        response.engine = vehicle.getEngine();
        response.year = vehicle.getYear();

        response.seats = (Objects.equals(vehicle.getVehicle_type(), "CAR"))
                ? (((Car) vehicle)).getSeats()
                : null;
        response.baggageCapacity = (Objects.equals(vehicle.getVehicle_type(), "CAR"))
                ? (((Car) vehicle)).getBaggage_capacity()
                : null;
        response.transmission = (Objects.equals(vehicle.getVehicle_type(), "CAR"))
                ? (((Car) vehicle)).getTransmission_type()
                : null;
        response.capacity = (Objects.equals(vehicle.getVehicle_type(), "MOTOR"))
                ? ((Motor) vehicle).getCapacity()
                : null;
        return response;
    }


}
