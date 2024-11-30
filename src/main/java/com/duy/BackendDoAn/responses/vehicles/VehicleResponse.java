package com.duy.BackendDoAn.responses.vehicles;

import com.duy.BackendDoAn.models.Vehicle;
import com.duy.BackendDoAn.responses.AttractionResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.duy.BackendDoAn.responses.rentalFacilities.RentalResponse;
import lombok.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleResponse {
    private Long id;

    private String model;

    @JsonProperty("facilities")
    private List<RentalResponse> rentalResponses;

    private String type;

    private DetailResponse details;


    public static VehicleResponse fromVehicle(Vehicle vehicle) {
        VehicleResponse response = new VehicleResponse();
        response.id = vehicle.getId();
        response.model = vehicle.getName();
        if (vehicle.getVehicleRentalFacilities() != null) {
            // Chuyển đổi danh sách vehicleRentalFacilities thành danh sách ID hoặc tên
            response.setRentalResponses(
                    vehicle.getVehicleRentalFacilities().stream()
                            .map(RentalResponse::fromRentalFacility) // Hoặc sử dụng ID, tùy thuộc vào yêu cầu của bạn
                            .collect(Collectors.toList())
            );
        } else {
            response.setRentalResponses(Collections.emptyList()); // Trả về danh sách rỗng nếu null
        }
        response.type = vehicle.getVehicle_type();
        response.details = DetailResponse.fromVehicle(vehicle);
        return response;
    }

}
