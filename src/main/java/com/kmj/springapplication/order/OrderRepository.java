package com.kmj.springapplication.order;

/**
 * 데이터 저장 공간 인터페이스
 */
public interface OrderRepository {
    Order insert(Order order);
}
