package com.suave.cloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Suave
 * @date 2021/1/11 11:08
 */
@Service
public class PaymentService {
    /**
     * 正常访问的方法
     *
     * @param id
     * @return
     */
    public String paymentInfoOk(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + " paymentInfoOk,id: " + id;
    }

    /**
     * 超时访问的方法
     *
     * @param id
     * @return
     */
    public String paymentInfoTimeOut(Integer id) {
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: " + Thread.currentThread().getName() + " paymentInfoTimeOut,id: " + id + " 耗时" + time + "秒";
    }
}
