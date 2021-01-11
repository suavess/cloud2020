package com.suave.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Suave
 * @date 2021/1/11 09:26
 */
@Configuration
public class FeignConfiguration {

    @Bean
    Logger.Level feignLogger() {
        return Logger.Level.FULL;
    }
}
