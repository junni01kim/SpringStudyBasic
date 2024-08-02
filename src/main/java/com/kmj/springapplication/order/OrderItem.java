package com.kmj.springapplication.order;

import java.util.UUID;

/**
 * 주문 상품(OrderItem) 클래스
 *
 * 주문 상품의 정보가 저장된다.
 *
 */
public class OrderItem {
    public final UUID productId;
    public final long productPrice;
    public final long quantity;

    /**
     *
     * @param productId 생산자를 특정하기 위한 아이디
     * @param productPrice 상품 가격
     * @param quantity 상품 수량
     */
    public OrderItem(UUID productId, long productPrice, int quantity) {
        this.productId = productId;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    /**
     * productId getter
     *
     * @return productId
     */
    public UUID getProductId() {
        return productId;
    }

    /**
     * productPrice getter
     *
     * @return productPrice
     */
    public long getProductPrice() {
        return productPrice;
    }

    /**
     * quantity getter
     *
     * @return quantity
     */
    public long getQuantity() {
        return quantity;
    }
}
