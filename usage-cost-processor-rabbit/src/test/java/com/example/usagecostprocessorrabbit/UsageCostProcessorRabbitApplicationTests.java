package com.example.usagecostprocessorrabbit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UsageCostProcessorRabbitApplicationTests {

    @Autowired
    private Function<UsageDetail, UsageCostDetail> processUsageCost;

    @Test
    void contextLoads() {
    }

    @Test
    public void testUsageCostProcessor() {

        var transformed = processUsageCost.apply(
                UsageDetail.builder()
                        .userId("user3")
                        .duration(101)
                        .data(502)
                        .from("test")
                        .build());
        var expected = UsageCostDetail.builder()
                .userId("user3")
                .callCost(10.100000000000001)
                .dataCost(25.1)
                .from("test")
                .build();
        assertEquals(expected, transformed);
    }

}
