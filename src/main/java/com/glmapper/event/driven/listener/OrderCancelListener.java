package com.glmapper.event.driven.listener;

import com.glmapper.event.driven.EventCenter;
import com.glmapper.event.driven.event.OrderCancelEvent;
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
public class OrderCancelListener implements EventListener {

    @Autowired
    private EventCenter eventCenter;

    @PostConstruct
    private void registry() {
        eventCenter.registry(this, OrderCancelEvent.class);
    }

    @Override
    public void trigger(OrderEvent event) {
        log.info("取消订单，订单id={}", event.getOrderId());
    }
}
