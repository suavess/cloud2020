package com.suave.cloud.service;

import org.springframework.stereotype.Component;

/**
 * @author Suave
 * @date 2021/1/11 16:18
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "======== PaymentFallbackService Fallback paymentInfoOk =======";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "======== PaymentFallbackService Fallback paymentInfoTimeout =======";
    }
}
