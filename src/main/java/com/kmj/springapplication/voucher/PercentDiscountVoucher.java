package com.kmj.springapplication.voucher;

import java.util.UUID;

public class PercentDiscountVoucher implements Voucher {
    private final UUID voucherId;
    private final long percent;

    /**
     * PercentDiscountVoucher initializer
     *
     * @param voucherId 바우처를 특정하기 위한 아이디
     * @param percent 할인을 위한 할인율
     */
    public PercentDiscountVoucher(UUID voucherId, long percent) {
        this.voucherId = voucherId;
        this.percent = percent;
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
     * 미션1 진행을 위한 함수
     * percent getter
     *
     * @return percent
     */
    @Override
    public long getValue() { return percent; }

    /**
     * 최종금액을 계산하기 위한 함수
     * 기존 가격을 퍼센트로 감가한다.
     *
     * @param beforeDiscount 할인가가 적용되지 않은 금액
     * @return 기존 가격에서 할인가가 적용된 최종 금액
     */
    @Override
    public long discount(long beforeDiscount) {
        return beforeDiscount * (percent / 100);
    }
}
