package com.joonhee.moneygate.chart.controller;


import com.joonhee.moneygate.chart.usecase.LeadingIndicator;
import com.joonhee.moneygate.chart.vo.Chart;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chart")
public class InflationIndicatorChartQueryController {
    private final LeadingIndicator leadingIndicator;

    public InflationIndicatorChartQueryController(LeadingIndicator leadingIndicator) {
        this.leadingIndicator = leadingIndicator;
    }

    @Operation(tags = "InflationIndicator")
    @GetMapping("/cb-consumer")
    Chart getCbConsumer() {
        return leadingIndicator.getCbConsumer();
    }

    @Operation(tags = "InflationIndicator")
    @GetMapping("/pce-price-index")
    Chart getPcePriceIndex() {
        return leadingIndicator.getPcePriceIndex();
    }

    @Operation(tags = "InflationIndicator")
    @GetMapping("/personal-income")
    Chart getPersonalIncome() {
        return leadingIndicator.getPersonalIncome();
    }

    @Operation(tags = "InflationIndicator")
    @GetMapping("/retail-sales")
    Chart getRetailSales() {
        return leadingIndicator.getRetailSales();
    }

    @Operation(tags = "InflationIndicator")
    @GetMapping("/new-home-sales")
    Chart getNewHomeSales() {
        return leadingIndicator.getNewHomeSales();
    }

    @Operation(tags = "InflationIndicator")
    @GetMapping("/existing-home-sales")
    Chart getExistingHomeSales() {
        return leadingIndicator.getExistingHomeSales();
    }

    @Operation(tags = "InflationIndicator")
    @GetMapping("/all-car-sales")
    Chart getAllCarSales() {
        return leadingIndicator.getAllCarSales();
    }

    @Operation(tags = "InflationIndicator")
    @GetMapping("/ism-manufacturing-pmi")
    Chart getIsmManufacturingPmi() {
        return leadingIndicator.getIsmManufacturingPMI();
    }

    @Operation(tags = "InflationIndicator")
    @GetMapping("/manufacturing-pmi")
    Chart getManufacturingPmi() {
        return leadingIndicator.getManufacturingPMI();
    }
}