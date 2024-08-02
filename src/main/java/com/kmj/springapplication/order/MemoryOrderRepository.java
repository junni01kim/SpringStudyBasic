package com.kmj.springapplication.order;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * OrderRepository에 대한 OrderRepository 클래스
 *
 * HashMap을 통해 데이터를 관리한다.
 */
@Repository
public class MemoryOrderRepository implements OrderRepository {
    private  final Map<UUID, Order> storage = new ConcurrentHashMap<UUID, Order>();

    /**
     * 새로운 Order를 Map에 저장하는 코드
     *
     * @param order 저장할 order 값
     * @return 저장된 order 값
     */
    @Override
    public Order insert(Order order) {
        storage.put(order.getOrderId(), order);
        return order;
    }
}
