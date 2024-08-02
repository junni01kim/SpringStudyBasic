package com.kmj.springapplication.order;

import com.kmj.springapplication.voucher.VoucherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Order를 동작하고 관리시킬 함수의 집합
 */
@Service
public class OrderService {
    private final VoucherService voucherService;
    private final OrderRepository orderRepository;

    /**
     * 서비스에서 사용할 객체를 전달 받는다. OrderService가 직접 생성하는 객체는 없다.
     *
     * @param voucherService
     * @param orderRepository
     */
    public OrderService(VoucherService voucherService, OrderRepository orderRepository) {
        this.voucherService = voucherService;
        this.orderRepository = orderRepository;
    }

    /**
     * 새로운 Order를 생성
     * Voucher 객체가 없는 함수
     *
     * @param customerId 상품을 구매한 Customer 고유 Id
     * @param orderItems 상품 목록
     * @return 추가된 상품 Order 객체
     */
    public Order createOrder(UUID customerId, List<OrderItem> orderItems) {
        var order = new Order(UUID.randomUUID(), customerId, orderItems );
        return orderRepository.insert(order);
    }

    /**
     * 새로운 Order를 생성
     * Voucher 객체가 있는 함수
     * 
     * @param customerId 상품을 구매한 Customer 고유 Id
     * @param orderItems 상품 목록
     * @param voucherId 상품에서 사용할 Voucher 고유 Id
     * @return 추가된 상훔 Order 객체
     */
    public Order createOrder(UUID customerId, List<OrderItem> orderItems, UUID voucherId) {
        var voucher = voucherService.getVoucher(voucherId);
        var order = new Order(UUID.randomUUID(), customerId, orderItems, voucher);
        orderRepository.insert(order);
        voucherService.useVoucher(voucher);
        return order;
    }
}
