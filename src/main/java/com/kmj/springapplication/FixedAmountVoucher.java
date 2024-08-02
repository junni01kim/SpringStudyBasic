package com.kmj.springapplication;

import java.util.UUID;

public class FixedAmountVoucher implements Voucher {
    private final UUID voucherId;
    private final long amount;

    /**
     * PercentDiscountVoucher initializer
     *
     * @param voucherId 바우처를 특정하기 위한 아이디
     * @param amount 감가를 위한 할인양
     */
    public FixedAmountVoucher(UUID voucherId, long amount) {
        this.voucherId = voucherId;
        this.amount = amount;
    }

    /**
     * voucherId getter
     *
     * @return voucherId
     */
    @Override
    public UUID getVoucherId() {
        return voucherId;
    }

    /**
     * 최종금액을 계산하기 위한 함수
     * 기존 가격을 고점 금액으로 감가한다.
     *
     * @param beforeDiscount 할인가가 적용되지 않은 금액
     * @return 기존 가격에서 할인가가 적용된 최종 금액
     */
    public long discount(long beforeDiscount) {
        return beforeDiscount - amount;
    }
}
