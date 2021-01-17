package com.suave.cloud.service.impl;

import com.suave.cloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;

/**
 * IMessageImpl
 * EnableBinding 注解定义消息的推送管道 生产方使用Source
 *
 * @author Suave
 * @date 2021/1/17 11:57 下午
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

    /**
     * 消息发送管道
     */
    @Autowired
    private MessageChannel output;

    /**
     * 消息发送
     *
     * @return
     */
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        boolean send = output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("========= serial:" + serial + "\t" + send);
        return null;
    }
}
