package com.joonhee.moneygate.chart.port.out;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "investing-com-leading-indicator", url = "${investing.com.src}")
public interface LeadingIndicatorFeignClient {
    @GetMapping("/48.json")
    InvestingComChartResponse getCbConsumer();

    @GetMapping("/904.json")
    InvestingComChartResponse getPce();

    @GetMapping("/234.json")
    InvestingComChartResponse getPersonalIncome();

    @GetMapping("/256.json")
    InvestingComChartResponse getRetailSales();

    @GetMapping("/222.json")
    InvestingComChartResponse getNewHomeSales();

    @GetMapping("/99.json")
    InvestingComChartResponse getExistingHomeSales();

    @GetMapping("/886.json")
    InvestingComChartResponse getAllCarSales();

    @GetMapping("/173.json")
    InvestingComChartResponse getIsmManufacturingPMI();

    @GetMapping("/829.json")
    InvestingComChartResponse getManufacturingPMI();
}