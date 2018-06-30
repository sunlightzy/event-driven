package com.glmapper.event.driven.event;

import com.glmapper.event.driven.constant.OrderEventType;

/**
 * @author: Jerry
 * @date: 2018/7/1
 */
public interface OrderEvent {

    Long getOrderId();

    OrderEventType getEventType();
}
