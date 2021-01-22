package com.suave.cloud.service;

import com.suave.cloud.entity.CommonResult;
import com.suave.cloud.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * @author Suave
 * @date 2021/1/22 10:43 上午
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444, "服务降级返回，-----PaymentFallbackService");
    }
}
