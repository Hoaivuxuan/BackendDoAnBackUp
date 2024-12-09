package com.duy.BackendDoAn.services;

import com.duy.BackendDoAn.configurations.VNPAYConfig;
import com.duy.BackendDoAn.responses.payment.VnPayResponse;
import com.duy.BackendDoAn.utils.VNPAYUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final VNPAYConfig vnpayConfig;
    public VnPayResponse createVnPayPayment(HttpServletRequest request) {
        long amount = Integer.parseInt(request.getParameter("amount")) * 100L;

        String bankCodeParam = request.getParameter("bankCode");
        String bankCode = bankCodeParam != null ? bankCodeParam : "";

        Map<String, String> vnpParamsMap = vnpayConfig.getVNPayConfig();
        vnpParamsMap.put("vnp_Amount", String.valueOf(amount));
        vnpParamsMap.put("vnp_BankCode", bankCode);
        vnpParamsMap.put("vnp_IpAddr", VNPAYUtils.getIpAddress(request));
        String queryUrl = VNPAYUtils.getPaymentURL(vnpParamsMap, true);
        String hashData = VNPAYUtils.getPaymentURL(vnpParamsMap, false);
        String vnpSecureHash = VNPAYUtils.hmacSHA512(vnpayConfig.getSecretKey(), hashData);
        queryUrl += "&vnp_SecureHash=" + vnpSecureHash;
        String paymentUrl = vnpayConfig.getPayUrl() + "?" + queryUrl;
        return VnPayResponse.builder()
                .code("00")
                .message("Success")
                .paymentUrl(paymentUrl)
                .build();
    }
}
