package com.kmj.springapplication;

/**
 * 주문 상태를 표시하기 위한 클래스
 */
public enum OrderStatus {
    ACCEPTED,
    PAYMENT_REQUIRED,
    PAYMENT_CONFIRMED,
    PAYMENT_REJECTED,
    READY_FOR_DELIVERY,
    SHIPPED,
    SETTLED,
    CANCELLED
}
