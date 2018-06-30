package com.glmapper.event.driven.exception;

/**
 * @author: Jerry
 * @date: 2018/7/1
 */
public class EventException extends RuntimeException {

    private static final long serialVersionUID = 7468382170454750907L;

    public EventException(String message) {
        super(message);
    }

    public EventException(String message, Throwable cause) {
        super(message, cause);
    }
}
