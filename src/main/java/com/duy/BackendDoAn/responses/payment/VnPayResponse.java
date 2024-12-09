package com.duy.BackendDoAn.responses.payment;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VnPayResponse {
    public String code;
    public String message;
    public String paymentUrl;
}
