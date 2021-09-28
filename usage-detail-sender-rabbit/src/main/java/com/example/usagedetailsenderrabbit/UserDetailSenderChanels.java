package com.example.usagedetailsenderrabbit;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;
import java.util.function.Supplier;

@Slf4j
@Configuration
public class UserDetailSenderChanels {

    private final String[] users = {"user1", "user2", "user3", "user4", "user5"};

    /**
     * This is a fixed-rate supplier. Configured using pooler
     */
    @Bean
    public Supplier<Message<UsageDetail>> usageDetailSupplier() {
        return () -> {
            var usageDetail = UsageDetail.builder()
                    .userId(this.users[new Random().nextInt(5)])
                    .duration(new Random().nextInt(300))
                    .data(new Random().nextInt(700))
                    .from("usageDetailSupplier-out-0")
                    .build();

            log.info("#### > SENDER: Going to send message from usageDetailSupplier[usageDetailSupplier-out-0] [{}]", usageDetail);
            return MessageBuilder
                    .withPayload(usageDetail)
                    .build();
        };
    }

    /**
     * Should use binding name usageDetailSupplierFlux-out-0.
     * Is relevant with flux only
     */
    @Bean
    public Supplier<Flux<Message<UsageDetail>>> usageDetailSupplierFlux() {
        return () -> Flux
                .interval(Duration.ofMillis(7000))
                .map((l) -> {
                    var usageDetail = UsageDetail.builder()
                            .userId(this.users[new Random().nextInt(5)])
                            .duration(new Random().nextInt(300))
                            .data(new Random().nextInt(700))
                            .from("usageDetailSupplier-out-0")
                            .build();
                    log.info("#### > SENDER: Going to send Flux<message> from usageDetailSupplier[usageDetailSupplierFlux-out-0] [{}]", usageDetail);
                    return MessageBuilder
                            .withPayload(usageDetail)
                            .build();
                });
    }

}
