package com.joonhee.moneygate.chart.controller;


import com.joonhee.moneygate.chart.service.LeadingIndicatorService;
import com.joonhee.moneygate.chart.vo.EconomyChart;
import com.joonhee.moneygate.common.httpresponse.HttpApiResponse;
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
    HttpApiResponse<EconomyChart> getCbConsumer() {
        return HttpApiResponse.of(leadingIndicator.getCbConsumer());
    }

    @Operation(tags = "InflationIndicator")
    @GetMapping("/pce-price-index")
    HttpApiResponse<EconomyChart> getPcePriceIndex() {
        return HttpApiResponse.of(leadingIndicator.getPcePriceIndex());
    }

    @Operation(tags = "InflationIndicator")
    @GetMapping("/personal-income")
    HttpApiResponse<EconomyChart> getPersonalIncome() {
        return HttpApiResponse.of(leadingIndicator.getPersonalIncome());
    }

    @Operation(tags = "InflationIndicator")
    @GetMapping("/retail-sales")
    HttpApiResponse<EconomyChart> getRetailSales() {
        return HttpApiResponse.of(leadingIndicator.getRetailSales());
    }

    @Operation(tags = "InflationIndicator")
    @GetMapping("/new-home-sales")
    HttpApiResponse<EconomyChart> getNewHomeSales() {
        return HttpApiResponse.of(leadingIndicator.getNewHomeSales());
    }

    @Operation(tags = "InflationIndicator")
    @GetMapping("/existing-home-sales")
    HttpApiResponse<EconomyChart> getExistingHomeSales() {
        return HttpApiResponse.of(leadingIndicator.getExistingHomeSales());
    }

    @Operation(tags = "InflationIndicator")
    @GetMapping("/all-car-sales")
    HttpApiResponse<EconomyChart> getAllCarSales() {
        return HttpApiResponse.of(leadingIndicator.getAllCarSales());
    }

    @Operation(tags = "InflationIndicator")
    @GetMapping("/ism-manufacturing-pmi")
    HttpApiResponse<EconomyChart> getIsmManufacturingPmi() {
        return HttpApiResponse.of(leadingIndicator.getIsmManufacturingPMI());
    }

    @Operation(tags = "InflationIndicator")
    @GetMapping("/manufacturing-pmi")
    HttpApiResponse<EconomyChart> getManufacturingPmi() {
        return HttpApiResponse.of(leadingIndicator.getManufacturingPMI());
    }
}