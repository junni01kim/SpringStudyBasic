package com.kmj.springapplication.order;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.*;

@Component
@ConfigurationProperties(prefix = "kdt")
public class OrderProperties implements InitializingBean {

    private String version;

    private int minimumOrderAmount;

    private List<String> supportVendors;

    private String description;

    // 환경변수를 가져올 수도 있다. <참조 우선순위는 환경변수가 더 높다.>
    @Value("${JAVA_HOME}")
    private String javaHome;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("[OrderProperties] Version: -> " + version);
        System.out.println("[OrderProperties] Minimum Order Amount: -> " + minimumOrderAmount);
        System.out.println("[OrderProperties] Support Vendors: -> " + supportVendors);
        System.out.println("[OrderProperties] Java Home: -> " + javaHome);
    }
}
