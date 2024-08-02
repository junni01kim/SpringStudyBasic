package com.kmj.springapplication.order;

import com.kmj.springapplication.voucher.Voucher;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * 주문(Order) 클래스
 *
 * 주문하는데에는 주문자, 주문 상품, 배송지의 관계가 필요하다.
 *
 */
public class Order {
    private final UUID orderid;
    private final UUID customerId;
    private final List<OrderItem> orderItems;
    private Optional<Voucher> voucher;
    private OrderStatus orderStatus = OrderStatus.ACCEPTED;

    public Order(UUID orderid, UUID customerId, List<OrderItem> orderItems) {
        this.orderid = orderid;
        this.customerId = customerId;
        this.orderItems = orderItems;
        this.voucher = Optional.empty();
    }

    /**
     *
     * @param orderid 주문을 특정하기 위한 아이디
     * @param customerId 주문자를 특정하기 위한 아이디
     * @param orderItems 주문 상품의 집합
     * @param voucher 영수증(최종 금액)
     */
    public Order(UUID orderid, UUID customerId, List<OrderItem> orderItems, Voucher voucher) {
        this.orderid = orderid;
        this.customerId = customerId;
        this.orderItems = orderItems;
        this.voucher = Optional.of(voucher);
    }

    /**
     * 각 상품의 수량 * 상품가격에 할인률을 부여한 금액
     * @return 최종 금액(할인률 포함)
     */
    public long totalAmount() {
        var beforeDiscount = orderItems.stream().map(v -> v.getProductPrice() * v.getQuantity())
                .reduce(0L, Long::sum);
        return voucher.map(value -> value.discount(beforeDiscount)).orElse(beforeDiscount);
    }

    /**
     * OrderStatus setter
     * @param orderStatus 변경할 주문 상태
     */
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
