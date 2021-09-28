package com.example.usagecostprocessorrabbit;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Slf4j
@Configuration
public class UsageCostProcessor {

    private double ratePerSecond = 0.1;

    private double ratePerMB = 0.05;

    @Bean
    public Function<UsageDetail, UsageCostDetail> processUsageCost() {

        return (UsageDetail usageDetail) -> {
            log.info("#### > PROCESSOR:  Received UserDetails [{}]", usageDetail);
            return UsageCostDetail.builder()
                    .userId(usageDetail.getUserId())
                    .callCost(usageDetail.getDuration() * this.ratePerSecond)
                    .dataCost(usageDetail.getData() * this.ratePerMB)
                    .from(usageDetail.getFrom())
                    .build();
        };
    }
}
