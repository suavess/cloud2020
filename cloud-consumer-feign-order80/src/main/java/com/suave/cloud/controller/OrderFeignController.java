package com.suave.cloud.controller;

import com.suave.cloud.entity.CommonResult;
import com.suave.cloud.entity.Payment;
import com.suave.cloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Suave
 * @date 2021/1/9 16:48
 */
@RestController
public class OrderFeignController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeOut() {
        return paymentFeignService.paymentFeignTimeOut();
    }
}
