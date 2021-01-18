package com.suave.cloud.controller;

import com.suave.cloud.entity.CommonResult;
import com.suave.cloud.entity.Payment;
import com.suave.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Suave
 * @date 2020/12/30 20:29
 */
@Slf4j
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("===== payment插入结果：{} ，端口号：{} =====", result, port);
        if (result > 0) {
            return new CommonResult<>(200, "插入成功！端口号：" + port, result);
        }
        return new CommonResult<>(500, "插入失败！端口号：" + port, null);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("===== payment查询结果：{}，端口号：{} =====", payment, port);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功！端口号：" + port, payment);
        }
        return new CommonResult<>(500, "查询失败！端口号：" + port, null);
    }

    @GetMapping("/payment/lb/get")
    public Object getlb() {
        return discoveryClient.getServices();
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("======service:{}", service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("{}\t{}\t{}\t{}", instance.getServiceId(), instance.getHost(), instance.getPort(), instance.getUri());
        }
        return this.discoveryClient;
    }

    /**
     * 设置超时时间，模拟feign超时处理
     *
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return port;
    }

    /**
     * zipkin 链路追踪演示
     *
     * @return
     */
    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "hi this is payment zipkin" + port;
    }
}

