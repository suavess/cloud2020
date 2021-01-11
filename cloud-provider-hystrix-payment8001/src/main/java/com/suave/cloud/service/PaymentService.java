package com.suave.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
            // 当前线程超时时间设置为三秒
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfoTimeOut(Integer id) {
//        int i = 10/0;
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: " + Thread.currentThread().getName() + " paymentInfoTimeOut,id: " + id + " 耗时" + time + "秒";
    }

    public String paymentInfoTimeOutHandler(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + " 系统繁忙或运行异常，请稍后再试,id: " + id;
    }
}
