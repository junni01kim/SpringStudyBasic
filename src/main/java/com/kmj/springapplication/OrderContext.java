package com.kmj.springapplication;

import java.util.Optional;
import java.util.UUID;

/**
 * 각 서비스 레포지토리 생성에 대한 책임을 갖는다.
 * 각각 레포 서비스 간 와이어링 의존관계를 맺는 것을 담당한다.
 */
public class OrderContext {

    public VoucherRepository voucherRepository(){
        return new VoucherRepository() {
            @Override
            public Optional<Voucher> findById(UUID voucherId) { return Optional.empty(); }
        };
    }

    public OrderRepository orderRepository(){
        return new OrderRepository() {
            @Override
            public void insert(Order order) {
            }
        };
    }

    public VoucherService voucherService() {
        return new VoucherService(voucherRepository());
    }
    public OrderService orderService() {
        return new OrderService(voucherService(),orderRepository());
    }
}
