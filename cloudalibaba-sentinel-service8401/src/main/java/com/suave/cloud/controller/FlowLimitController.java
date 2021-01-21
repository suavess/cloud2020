package com.suave.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Suave
 * @date 2021/1/21 7:32 下午
 */
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        return "----------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "----------testB";
    }
}
