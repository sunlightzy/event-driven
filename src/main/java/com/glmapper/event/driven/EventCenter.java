package com.glmapper.event.driven;

import com.glmapper.event.driven.event.OrderEvent;
import com.glmapper.event.driven.exception.EventException;
import com.glmapper.event.driven.listener.EventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/**
 * @author: Jerry
 * @date: 2018/7/1
 */
public class EventCenter {

    /**
     * 事件类型和监听器的绑定映射
     */
    private final ConcurrentHashMap<Class<?>, List<EventListener>> subscribers = new ConcurrentHashMap<>();

    private final Executor executor;

    public EventCenter(Executor executor) {
        this.executor = executor;
    }

    /**
     * 绑定 监听器与事件类型
     *
     * @param eventListener
     * @param clazz
     */
    public void registry(EventListener eventListener, Class<?> clazz) {
        List<EventListener> listeners = subscribers.get(clazz);
        if (listeners == null) {
            listeners = new ArrayList<>();
        }
        listeners.add(eventListener);
        subscribers.put(clazz, listeners);
    }

    /**
     * 向事件中心发送消息
     *
     * @param orderEvent
     */
    public void post(OrderEvent orderEvent) {
        List<EventListener> listeners = subscribers.get(orderEvent.getClass());
        if (listeners == null || listeners.size() == 0) {
            throw new EventException("找不到该事件的监听器");
        }
        for (EventListener listener : listeners) {
            //线程池异步处理
            executor.execute(() -> listener.trigger(orderEvent));
        }
    }
}
