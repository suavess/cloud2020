package com.suave.cloud.controller;

import com.suave.cloud.entity.CommonResult;
import com.suave.cloud.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashMap;

/**
 * @author Suave
 * @date 2021/1/19 11:56 下午
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    /**
     * 模拟数据库,为省事,不写数据库层面
     */
    @PostConstruct
    public void init() {
        hashMap.put(1L, new Payment(1L, "28a8c1e3bc2742d8848569891fb42181"));
        hashMap.put(2L, new Payment(2L, "28a4c1e3bc2742d8848569891fb42181"));
        hashMap.put(3L, new Payment(3L, "28a5c1e3bc2742d8848569891fb42181"));
    }

    @RequestMapping("/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return "nacos registry, serverPort:" + serverPort + "\t id:" + id;
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult<>(200, "from mysql,serverPort: " + serverPort, payment);
        return result;
    }
}

