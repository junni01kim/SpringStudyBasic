package com.kmj.springapplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;
import java.util.UUID;

/**
 * 각 서비스 레포지토리 생성에 대한 책임을 갖는다.
 * 각각 레포 서비스 간 와이어링 의존관계를 맺는 것을 담당한다.
 */
@Configuration
public class AppConfiguration {
    @Bean
    public VoucherRepository voucherRepository(){
        return new VoucherRepository() {
            @Override
            public Optional<Voucher> findById(UUID voucherId) { return Optional.empty(); }
        };
    }

    @Bean
    public OrderRepository orderRepository(){
        return new OrderRepository() {
            @Override
            public void insert(Order order) {
            }
        };
    }

    @Bean
    public VoucherService voucherService(VoucherRepository voucherRepository) {
        return new VoucherService(voucherRepository);
    }

    @Bean
    public OrderService orderService(VoucherService voucherService,OrderRepository orderRepository) {
        return new OrderService(voucherService,orderRepository);
    }
}
