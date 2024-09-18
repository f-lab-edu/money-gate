package com.joonhee.moneygate.chart.port.out;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "investing-com-inflation-indicator", url = "${investing.com.src}")
public interface InflationIndicatorFeignClient {
    @GetMapping("/421.json")
    ChartResponse getCoreCpi();
    @GetMapping("/733.json")
    ChartResponse getCpi();
    @GetMapping("/735.json")
    ChartResponse getCorePpi();
    @GetMapping("/331.json")
    ChartResponse getEmploymentCostIndex();
    @GetMapping("/1777.json")
    ChartResponse getAverageHourlyEarnings();
}
