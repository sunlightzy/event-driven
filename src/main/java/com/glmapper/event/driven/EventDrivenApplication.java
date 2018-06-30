package com.glmapper.event.driven;

import com.glmapper.event.driven.event.OrderCancelEvent;
import com.glmapper.event.driven.event.OrderCreateEvent;
import com.glmapper.event.driven.sender.EventSender;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.*;

/**
 * @author: Jerry
 * @date: 2018/7/1
 */
@Slf4j
@SpringBootApplication
public class EventDrivenApplication {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = SpringApplication.run(EventDrivenApplication.class, args);
        EventSender eventSender = applicationContext.getBean(EventSender.class);
        while (true) {
            long orderId = ThreadLocalRandom.current().nextLong();
            eventSender.post(new OrderCreateEvent(orderId));
            log.info("有一个新订单，订单id={}", orderId);

            orderId = ThreadLocalRandom.current().nextLong();
            eventSender.post(new OrderCancelEvent(orderId));
            log.info("有一个订单取消，订单id={}", orderId);

            Thread.sleep(ThreadLocalRandom.current().nextLong(1000, 10000));
        }
    }

    @Bean
    public EventCenter eventCenter() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("event-bus-%d").build();
        int corePoolSize = Runtime.getRuntime().availableProcessors();
        int maximumPoolSize = corePoolSize * 2;
        Executor pool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, 10L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024),
                namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        return new EventCenter(pool);
    }
}
