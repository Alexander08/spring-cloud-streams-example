package com.example.usagedetailsenderrabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

/*
 * More details on:
 * https://docs.spring.io/spring-cloud-stream/docs/3.1.2/reference/html/spring-cloud-stream.html#_using_streambridge
 *
 * */
@EnableScheduling
@Component
@Slf4j
public class UsageDetailSender {

    private final static String BINDING_NAME = "usageDetail-out-0";

    @Autowired
    private StreamBridge streamBridge;

    private final String[] users = {"user1", "user2", "user3", "user4", "user5"};

    @Scheduled(fixedDelay = 5000)
    public void sendEvents() {

        var usageDetail = UsageDetail.builder()
                .userId(this.users[new Random().nextInt(5)])
                .duration(new Random().nextInt(300))
                .data(new Random().nextInt(700))
                .from(BINDING_NAME)
                .build();

        log.info("#### > SENDER: Going to send from sendEvents[{}] message [{}]", BINDING_NAME, usageDetail);

        var message = MessageBuilder
                .withPayload(usageDetail)
                .build();

        this.streamBridge.send(BINDING_NAME, message);
    }
}
