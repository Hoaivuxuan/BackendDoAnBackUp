package com.duy.BackendDoAn.controllers;

import com.duy.BackendDoAn.responses.payment.VnPayResponse;
import com.duy.BackendDoAn.services.PaymentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
    @GetMapping("/vn-pay")
    public ResponseEntity<VnPayResponse> pay(HttpServletRequest request) {
        VnPayResponse response = paymentService.createVnPayPayment(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/vn-pay-callback")
    public ResponseEntity<VnPayResponse> payCallbackHandler(HttpServletRequest request) {
        String status = request.getParameter("vnp_ResponseCode");
        if(status.equals("00")) {
            return ResponseEntity.ok(VnPayResponse.builder()
                    .code("00")
                    .message("Success")
                    .build());
        }
        else {
            return ResponseEntity.badRequest().body(VnPayResponse.builder()
                    .code(status)
                    .message("Transaction failed")
                    .build());
        }
    }
}
