package com.joonhee.moneygate.configure;

import com.joonhee.moneygate.chart.port.out.InflationIndicatorFeignClient;
import com.joonhee.moneygate.chart.port.out.LeadingIndicatorFeignClient;
import com.joonhee.moneygate.chart.service.InflationIndicatorProcessor;
import com.joonhee.moneygate.chart.service.LeadingIndicatorProcessor;
import com.joonhee.moneygate.chart.usecase.InflationIndicator;
import com.joonhee.moneygate.chart.usecase.LeadingIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChartRegisterBean {

    private final InflationIndicatorFeignClient inflationIndicatorFeignClient;
    private final LeadingIndicatorFeignClient leadingIndicatorFeignClient;

    public ChartRegisterBean(
            InflationIndicatorFeignClient inflationIndicatorFeignClient,
            LeadingIndicatorFeignClient leadingIndicatorFeignClient
    ) {
        this.inflationIndicatorFeignClient = inflationIndicatorFeignClient;
        this.leadingIndicatorFeignClient = leadingIndicatorFeignClient;
    }

    @Bean
    public InflationIndicator inflationIndicatorService() {
        return new InflationIndicatorProcessor(inflationIndicatorFeignClient);
    }

    @Bean
    public LeadingIndicator leadingIndicatorService() {
        return new LeadingIndicatorProcessor(leadingIndicatorFeignClient);
    }
}
