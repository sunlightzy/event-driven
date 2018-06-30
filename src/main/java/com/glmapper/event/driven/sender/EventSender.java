package com.glmapper.event.driven.sender;

import com.glmapper.event.driven.EventCenter;
import com.glmapper.event.driven.event.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: Jerry
 * @date: 2018/7/1
 */
@Slf4j
@Component
public class EventSender {

    @Autowired
    private EventCenter eventCenter;

    public void post(OrderEvent event) {
        eventCenter.post(event);
    }
}
