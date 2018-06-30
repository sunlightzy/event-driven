package com.glmapper.event.driven.event;

import com.glmapper.event.driven.constant.OrderEventType;

/**
 * @author: Jerry
 * @date: 2018/7/1
 */
public class OrderCancelEvent implements OrderEvent {

    private Long orderId;

    public OrderCancelEvent(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public Long getOrderId() {
        return this.orderId;
    }

    @Override
    public OrderEventType getEventType() {
        return OrderEventType.CANCEL;
    }
}
