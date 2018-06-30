package com.glmapper.event.driven.constant;

/**
 * @author: Jerry
 * @date: 2018/7/1
 */
public enum OrderEventType {
    /**
     * 订单创建操作
     */
    CREATE(1, "订单创建"),
    /**
     * 订单取消操作
     */
    CANCEL(-1, "订单取消");

    OrderEventType(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    /**
     * 操作 id
     */
    private int id;
    /**
     * 描述
     */
    private String desc;
}
