package com.example.usagecostloggerrabbit;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Consumer;

import static org.mockito.AdditionalAnswers.delegatesTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@SpringBootTest
class UsageCostLoggerRabbitApplicationTests {

    @Autowired
    private Consumer<UsageCostDetail> process;

    @Test
    void contextLoads() {
    }

    @Test
    public void testUsageCostLogger() {

        var build = UsageCostDetail.builder()
                .userId("user3")
                .from("test")
                .callCost(10.100000000000001)
                .dataCost(25.1)
                .build();
        ArgumentCaptor<UsageCostDetail> captor = ArgumentCaptor.forClass(UsageCostDetail.class);
        var spyProcess = spyLambda(process, Consumer.class);
        spyProcess.accept(build);
        verify(spyProcess).accept(captor.capture());
    }

    @SuppressWarnings("unchecked")
    public static <R, G extends R> G spyLambda(final G lambda, final Class<R> lambdaType) {
        return (G) mock(lambdaType, delegatesTo(lambda));
    }

}
