package com.duy.BackendDoAn.responses.hotels;

import com.duy.BackendDoAn.models.Hotel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelPolicyResponse {
    @JsonProperty("cancellation_policy")
    private String cancellationPolicy;

    @JsonProperty("deposit_required")
    private String depositRequired;

    @JsonProperty("pets_allowed")
    private boolean petsAllowed;

    @JsonProperty("smoking_policy")
    private boolean smokingPolicy;

    @JsonProperty("extra_bed_policy")
    private boolean extraBedPolicy;

    public static HotelPolicyResponse fromHotelPolicy(Hotel hotel){
        HotelPolicyResponse hotelPolicyResponse = HotelPolicyResponse.builder()
                .cancellationPolicy(hotel.getCancellation_policy())
                .depositRequired(hotel.getDeposit_required())
                .petsAllowed(hotel.isPets_allowed())
                .smokingPolicy(hotel.isSmoking_policy())
                .extraBedPolicy(hotel.isExtra_bed_policy())
                .build();
        return hotelPolicyResponse;
    }
}
