package com.duy.BackendDoAn.responses.hotels;

import com.duy.BackendDoAn.models.HotelPolicy;
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
    private String smokingPolicy;

    @JsonProperty("extra_bed_policy")
    private String extraBedPolicy;

    public static HotelPolicyResponse fromHotelPolicy(HotelPolicy hotelPolicy){
        HotelPolicyResponse hotelPolicyResponse = HotelPolicyResponse.builder()
                .cancellationPolicy(hotelPolicy.getCancellation_policy())
                .depositRequired(hotelPolicy.getDeposit_required())
                .petsAllowed(hotelPolicy.isPets_allowed())
                .smokingPolicy(hotelPolicy.getSmoking_policy())
                .extraBedPolicy(hotelPolicy.getExtra_bed_policy())
                .build();
        return hotelPolicyResponse;
    }
}
