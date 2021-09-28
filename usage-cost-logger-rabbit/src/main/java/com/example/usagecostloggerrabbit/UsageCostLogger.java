package com.example.usagecostloggerrabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Slf4j
@Configuration
public class UsageCostLogger {

    @Bean
    public Consumer<UsageCostDetail> process() {

        return (UsageCostDetail usageCostDetail) -> {
            log.info("#### > LOGGER: Received message to consume [{}]", usageCostDetail);
        };
    }
}
