package com.suave.cloud.service.impl;

import com.suave.cloud.dao.PaymentDao;
import com.suave.cloud.entity.Payment;
import com.suave.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Suave
 * @date 2020/12/30 20:10
 */
@SuppressWarnings("all")
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
