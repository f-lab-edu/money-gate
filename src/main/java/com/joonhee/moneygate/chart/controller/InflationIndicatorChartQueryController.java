package com.joonhee.moneygate.chart.controller;


import com.joonhee.moneygate.chart.service.LeadingIndicatorService;
import com.joonhee.moneygate.chart.vo.EconomyChart;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chart")
public class InflationIndicatorChartQueryController {
    private final LeadingIndicatorService leadingIndicator;

    public InflationIndicatorChartQueryController(LeadingIndicatorService leadingIndicator) {
        this.leadingIndicator = leadingIndicator;
    }

    @Operation(tags = "InflationIndicator")
    @GetMapping("/cb-consumer")
    EconomyChart getCbConsumer() {
        return leadingIndicator.getCbConsumer();
    }

    @Operation(tags = "InflationIndicator")
    @GetMapping("/pce-price-index")
    EconomyChart getPcePriceIndex() {
        return leadingIndicator.getPcePriceIndex();
    }

    @Operation(tags = "InflationIndicator")
    @GetMapping("/personal-income")
    EconomyChart getPersonalIncome() {
        return leadingIndicator.getPersonalIncome();
    }

    @Operation(tags = "InflationIndicator")
    @GetMapping("/retail-sales")
    EconomyChart getRetailSales() {
        return leadingIndicator.getRetailSales();
    }

    @Operation(tags = "InflationIndicator")
    @GetMapping("/new-home-sales")
    EconomyChart getNewHomeSales() {
        return leadingIndicator.getNewHomeSales();
    }

    @Operation(tags = "InflationIndicator")
    @GetMapping("/existing-home-sales")
    EconomyChart getExistingHomeSales() {
        return leadingIndicator.getExistingHomeSales();
    }

    @Operation(tags = "InflationIndicator")
    @GetMapping("/all-car-sales")
    EconomyChart getAllCarSales() {
        return leadingIndicator.getAllCarSales();
    }

    @Operation(tags = "InflationIndicator")
    @GetMapping("/ism-manufacturing-pmi")
    EconomyChart getIsmManufacturingPmi() {
        return leadingIndicator.getIsmManufacturingPMI();
    }

    @Operation(tags = "InflationIndicator")
    @GetMapping("/manufacturing-pmi")
    EconomyChart getManufacturingPmi() {
        return leadingIndicator.getManufacturingPMI();
    }
}