package com.kmj.springapplication.voucher;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * VoucherRepository에 대한 VoucherRepository 클래스
 *
 * HashMap을 통해 데이터를 관리한다.
 */
@Repository
@Qualifier("memory") // 여러 IoC 조건에서 VoucherRepository가 존재한다면, Qualifier annotation을 통해 Bean을 특정한다.
public class MemoryVoucherRepository implements VoucherRepository, InitializingBean, DisposableBean {
    private final Map<UUID, Voucher> storage = new ConcurrentHashMap<>();

    /**
     * 필요한 voucherId에 해당하는 Voucher를 찾는 함수
     *
     * @param voucherId 찾길 희망하는 Voucher 객체 고유 Id
     * @return Voucher 없다면 Null
     */
    @Override
    public Optional<Voucher> findById(UUID voucherId) {
        return Optional.ofNullable(storage.get(voucherId));
    }

    /**
     * voucher 객체를 Repository에 저장하는 함수
     *
     * @param voucher 저장할 voucher 객체
     * @return 저장한 voucher 객체
     */
    @Override
    public Voucher insert(Voucher voucher) {
        storage.put(voucher.getVoucherId(), voucher);
        return voucher;
    }

    /**
     * Bean 생성 전 호출되는 함수
     */
    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct called!");
    }

    /**
     * Bean 생성 후 호출되는 함수
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet called!");
    }

    /**
     * Bean 삭제 전 호출되는 함수
     */
    @PreDestroy
    public void preDestory(){
        System.out.println("preDestory called!");
    }

    /**
     * Bean 삭제 후 호출되는 함수
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("destroy called!");
    }
}
