package com.kmj.springapplication.voucher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.UUID;

@Service
public class VoucherService {
    private final VoucherRepository voucherRepository;

    @Autowired // 이게 예전에는 디폴트였음
    public VoucherService(VoucherRepository voucherRepository) {
        this.voucherRepository = voucherRepository;
    }

    // 임시 생성자 <-- 생성자가 두개인 경우 어떤 것을 자동으로 주입할지 모르니 하나에 Autowired를 기술한다.
    public VoucherService(@Qualifier("memory") VoucherRepository voucherRepository, String temp) {
        this.voucherRepository = voucherRepository;
    }

    public Voucher getVoucher(UUID voucherId){
        return voucherRepository
                .findById(voucherId)
                .orElseThrow(()->new RuntimeException(MessageFormat.format("Can not find a voucher for {0}",voucherId)));
    }

    public void useVoucher(Voucher voucher) {

    }
}
