package com.suave.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ribbon官方文档提示不能放在项目@ComponentScan注解能扫描到的地方
 * 否则配置将被所有ribbon客户端共享
 * 无法达到个性化的配置功能
 *
 * @author Suave
 * @date 2021/1/9 11:48
 */
@Configuration
public class MyRule {

    @Bean
    public IRule iRule() {
        return new RandomRule();
    }
}
