package com.glmapper.event.driven.listener;

import com.glmapper.event.driven.EventCenter;
import com.glmapper.event.driven.event.OrderCreateEvent;
import com.glmapper.event.driven.event.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author: Jerry
 * @date: 2018/7/1
 */
@Slf4j
@Component
public class OrderCreateListener implements EventListener {

    @Autowired
    private EventCenter eventCenter;

    @PostConstruct
    private void registry() {
        eventCenter.registry(this, OrderCreateEvent.class);
    }

    @Override
    public void trigger(OrderEvent event) {
        log.info("创建订单，订单id={}", event.getOrderId());
    }
}
