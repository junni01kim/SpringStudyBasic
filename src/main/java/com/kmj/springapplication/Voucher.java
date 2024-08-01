package com.kmj.springapplication;

import java.util.UUID;

/**
 * PercentDiscountVoucher, FixedAmountVoucher class를
 * 런타임 의존성으로 만들기 위한 인터페이스
 *
 * 비즈니스에서 최종금액을 위해 이용된다.
 */
public interface Voucher {
    /**
     * voucherId getter
     *
     * @return voucherId
     */
    UUID getVoucherId();

    /**
     * 최종금액을 계산하기 위한 함수
     *
     * @param beforeDiscount 할인가가 적용되지 않은 금액
     * @return 기존 가격에서 할인가가 적용된 최종 금액
     */
    long discount(long beforeDiscount);
}
