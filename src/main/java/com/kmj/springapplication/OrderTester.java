package com.kmj.springapplication;

import com.kmj.springapplication.configuration.AppConfiguration;
import com.kmj.springapplication.order.OrderItem;
import com.kmj.springapplication.order.OrderService;
import com.kmj.springapplication.voucher.FixedAmountVoucher;
import com.kmj.springapplication.voucher.VoucherRepository;
import org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.UUID;

/**
 * 프로젝트의 코드 테스트를 진행하기 위한 클래스
 */
public class OrderTester {
    public static void main(String[] args) {
        var applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);

        var environment = applicationContext.getEnvironment();
        var property = environment.getProperty("kmj.version");
        var minimumOrderAmount = environment.getProperty("kmj.minimun-order-amount", Integer.class);
        var supportVendors = environment.getProperty("kmj.support-vendors", String.class);
        var descriptions = environment.getProperty("kmj.descriptions", String.class);
        System.out.println(MessageFormat.format("{0} {1} {2} {3}", property, minimumOrderAmount, supportVendors, descriptions));

        var customerId = UUID.randomUUID();

        var voucherRepository = BeanFactoryAnnotationUtils.qualifiedBeanOfType(applicationContext.getBeanFactory(),VoucherRepository.class, "memory");
        var voucher = voucherRepository.insert(new FixedAmountVoucher(UUID.randomUUID(), 10L));
        var orderService = applicationContext.getBean(OrderService.class);
        var order = orderService.createOrder(customerId, new ArrayList<OrderItem>() {{
            add(new OrderItem(UUID.randomUUID(), 100L,1));
        }}, voucher.getVoucherId());
        Assert.isTrue(order.totalAmount()==90L, MessageFormat.format("totalAmount {0} is not 90L", order.totalAmount()));

        // container에 있는 Bean들이 모두 소멸한다.
        applicationContext.close();

    }
}
