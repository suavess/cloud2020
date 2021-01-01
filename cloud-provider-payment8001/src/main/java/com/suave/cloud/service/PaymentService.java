package com.suave.cloud.service;

import com.suave.cloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author Suave
 * @date 2020/12/30 20:09
 */
public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(Long id);
}
