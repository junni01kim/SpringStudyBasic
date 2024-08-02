package com.kmj.springapplication.voucher;

import java.util.Optional;
import java.util.UUID;

/**
 * 데이터 저장 공간 인터페이스
 */
public interface VoucherRepository {
    Optional<Voucher> findById(UUID voucherId);
    Voucher insert(Voucher voucher);
}
