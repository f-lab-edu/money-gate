package com.joonhee.moneygate.configure;

import feign.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.joonhee")
public class FeignClientConfig {
    @Value("${investing.connectTimeout}")
    private int connectTimeoutMillis;
    @Value("${investing.readTimeout}")
    private int readTimeoutMillis;

    @Bean
    public Request.Options requestTimeoutOptions() {
        return new Request.Options(connectTimeoutMillis, readTimeoutMillis);
    }
}