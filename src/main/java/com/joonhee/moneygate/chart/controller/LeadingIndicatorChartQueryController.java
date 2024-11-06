package com.joonhee.moneygate.chart.controller;


import com.joonhee.moneygate.chart.service.InflationIndicatorService;
import com.joonhee.moneygate.chart.vo.EconomyChart;
import com.joonhee.moneygate.common.HttpApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chart")
public class LeadingIndicatorChartQueryController {
    private final InflationIndicatorService inflationIndicator;

    public LeadingIndicatorChartQueryController(InflationIndicatorService inflationIndicator) {
        this.inflationIndicator = inflationIndicator;
    }

    @Operation(tags = "LeadingIndicator")
    @GetMapping("/core-cpi")
    HttpApiResponse<EconomyChart> getCoreCpi() {
        return HttpApiResponse.of(inflationIndicator.getCoreCpi());
    }

    @Operation(tags = "LeadingIndicator")
    @GetMapping("/cpi")
    HttpApiResponse<EconomyChart> getCpi() {
        return HttpApiResponse.of(inflationIndicator.getCpi());
    }

    @Operation(tags = "LeadingIndicator")
    @GetMapping("/core-ppi")
    HttpApiResponse<EconomyChart> getCorePpi() {
        return HttpApiResponse.of(inflationIndicator.getCorePpi());
    }

    @Operation(tags = "LeadingIndicator")
    @GetMapping("/employment-cost-index")
    HttpApiResponse<EconomyChart> getEmploymentCostIndex() {
        return HttpApiResponse.of(inflationIndicator.getEmploymentCostIndex());
    }

    @Operation(tags = "LeadingIndicator")
    @GetMapping("/average-hourly-earnings")
    HttpApiResponse<EconomyChart> getAverageHourlyEarnings() {
        return HttpApiResponse.of(inflationIndicator.getAverageHourlyEarnings());
    }
}