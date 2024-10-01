package com.joonhee.moneygate.chart.port.out;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "investing-com-inflation-indicator", url = "${investing.com.src}")
public interface InflationIndicatorFeignClient {
    @GetMapping("/421.json")
    InvestingComChartResponse getCoreCpi();
    @GetMapping("/733.json")
    InvestingComChartResponse getCpi();
    @GetMapping("/735.json")
    InvestingComChartResponse getCorePpi();
    @GetMapping("/331.json")
    InvestingComChartResponse getEmploymentCostIndex();
    @GetMapping("/1777.json")
    InvestingComChartResponse getAverageHourlyEarnings();
}
