package com.suave.cloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.suave.cloud.entity.CommonResult;

/**
 * @author Suave
 * @date 2021/1/22 10:09 上午
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(444, "按客户自定义,Global HandlerException----1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(444, "按客户自定义,Global HandlerException----2");
    }

}
