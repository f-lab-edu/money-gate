package com.joonhee.moneygate.chart.port.out;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "investing-com-leading-indicator", url = "${investing.com.src}")
public interface LeadingIndicatorFeignClient {
    @GetMapping("/48.json")
    ChartResponse getCbConsumer();

    @GetMapping("/904.json")
    ChartResponse getPce();

    @GetMapping("/234.json")
    ChartResponse getPersonalIncome();

    @GetMapping("/256.json")
    ChartResponse getRetailSales();

    @GetMapping("/222.json")
    ChartResponse getNewHomeSales();

    @GetMapping("/99.json")
    ChartResponse getExistingHomeSales();

    @GetMapping("/886.json")
    ChartResponse getAllCarSales();

    @GetMapping("/173.json")
    ChartResponse getIsmManufacturingPMI();

    @GetMapping("/829.json")
    ChartResponse getManufacturingPMI();
}