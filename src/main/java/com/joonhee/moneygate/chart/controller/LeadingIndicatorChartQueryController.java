package com.joonhee.moneygate.chart.controller;


import com.joonhee.moneygate.chart.usecase.InflationIndicator;
import com.joonhee.moneygate.chart.vo.EconomyChart;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/chart")
public class LeadingIndicatorChartQueryController {
    private final InflationIndicator inflationIndicator;

    public LeadingIndicatorChartQueryController(InflationIndicator inflationIndicator) {
        this.inflationIndicator = inflationIndicator;
    }

    @Operation(tags = "LeadingIndicator")
    @GetMapping("/core-cpi")
    EconomyChart getCoreCpi() {
        return inflationIndicator.getCoreCpi();
    }

    @Operation(tags = "LeadingIndicator")
    @GetMapping("/cpi")
    EconomyChart getCpi() {
        return inflationIndicator.getCpi();
    }

    @Operation(tags = "LeadingIndicator")
    @GetMapping("/core-ppi")
    EconomyChart getCorePpi() {
        return inflationIndicator.getCorePpi();
    }

    @Operation(tags = "LeadingIndicator")
    @GetMapping("/employment-cost-index")
    EconomyChart getEmploymentCostIndex() {
        return inflationIndicator.getEmploymentCostIndex();
    }

    @Operation(tags = "LeadingIndicator")
    @GetMapping("/average-hourly-earnings")
    EconomyChart getAverageHourlyEarnings() {
        return inflationIndicator.getAverageHourlyEarnings();
    }
}