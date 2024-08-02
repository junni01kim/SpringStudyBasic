package com.kmj.springapplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;
import java.util.UUID;

/**
 * 각 서비스 레포지토리 생성에 대한 책임을 갖는다.
 * 각각 레포 서비스 간 와이어링 의존관계를 맺는 것을 담당한다.
 *
 * Q. AppConfiguration은 자동으로 다른 객체를 만들어주는건가?
 * A. getBean(text)는 text라는 이름의 클래스를 자동으로 IoC해서 가져오는 것
 */
@Configuration
@ComponentScan //패키지 기준으로 Service
public class AppConfiguration {
    /**
     * Repository Annotation을 닮으로써 없어도 자동으로 Bean이 등록되어 진다.
     */
//    /**
//     * VoucherRepository를 생성한다.
//     * @return VoucherRepository interface로 클래스를 제작
//     */
//    @Bean
//    public VoucherRepository voucherRepository(){
//        return new VoucherRepository() {
//            @Override
//            public Optional<Voucher> findById(UUID voucherId) { return Optional.empty(); }
//        };
//    }
//
//    /**
//     * OrderRepositort를 생성한다.
//     * @return OrderRepositort interface로 클래스를 제작
//     */
//    @Bean
//    public OrderRepository orderRepository(){
//        return new OrderRepository() {
//            @Override
//            public Order insert(Order order) {
//            }
//        };
//    }

    /**
     * Service Annotation을 닮으로써 없어도 자동으로 Bean이 등록되어 진다.
     */
//    /**
//     * VoucherService를 생성한다.
//     * @param voucherRepository
//     * @return
//     */
//    @Bean
//    public VoucherService voucherService(VoucherRepository voucherRepository) {
//        return new VoucherService(voucherRepository);
//    }
//
//    /**
//     * OrderService를 생성한다.
//     * 생성자 두개는 따로 호출하여 대입할 필요가 없다.
//     *
//     * @param voucherService 현재 자동으로 voucherService까지 호출되어 생성된다.
//     * @param orderRepository 현재 자동으로 orderRepository까지 호출되어 생성된다.
//     * @return
//     */
//    @Bean
//    public OrderService orderService(VoucherService voucherService, OrderRepository orderRepository) {
//        return new OrderService(voucherService,orderRepository);
//    }
}
