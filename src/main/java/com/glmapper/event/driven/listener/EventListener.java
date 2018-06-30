package com.glmapper.event.driven.listener;

import com.glmapper.event.driven.event.OrderEvent;

/**
 * @author: Jerry
 * @date: 2018/7/1
 */
public interface EventListener{

    /**
     * 事件触发时调用
     *
     * @param event
     */
    void trigger(OrderEvent event);
}
