package com.duy.BackendDoAn.responses.vehicles;

import com.duy.BackendDoAn.models.Car;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailCarResponse extends DetailResponse{
    private String transmission;
    @JsonProperty("baggage_capacity")
    private Long baggageCapacity;
    private Long seats;

    public static DetailCarResponse fromCar(Car car) {
        DetailCarResponse response = new DetailCarResponse();
        response.setFuel(car.getFuel());
        response.setBrand(car.getBrand());
        response.setEngine(car.getEngine());
        response.setYear(car.getYear());
        response.setSeats(car.getSeats());
        response.setBaggageCapacity(car.getBaggage_capacity());
        response.setTransmission(car.getTransmission_type());
        return response;
    }
}
