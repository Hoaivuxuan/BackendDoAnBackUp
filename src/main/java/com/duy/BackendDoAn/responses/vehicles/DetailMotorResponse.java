package com.duy.BackendDoAn.responses.vehicles;

import com.duy.BackendDoAn.models.Motor;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailMotorResponse extends DetailResponse {
    private String capacity;

    public static DetailMotorResponse fromMotor(Motor motor) {
        DetailMotorResponse response = new DetailMotorResponse();
        response.setFuel(motor.getFuel());
        response.setBrand(motor.getBrand());
        response.setEngine(motor.getEngine());
        response.setYear(motor.getYear());
        response.setCapacity(motor.getCapacity());
        return response;
    }

}
