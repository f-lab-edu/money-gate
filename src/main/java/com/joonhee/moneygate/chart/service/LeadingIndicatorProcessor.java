package com.joonhee.moneygate.chart.service;

import com.joonhee.moneygate.chart.port.out.LeadingIndicatorFeignClient;
import com.joonhee.moneygate.chart.usecase.LeadingIndicator;
import com.joonhee.moneygate.chart.vo.Chart;

public class LeadingIndicatorProcessor implements LeadingIndicator {
    private final LeadingIndicatorFeignClient leadingIndicatorInvestingComPort;

    public LeadingIndicatorProcessor(
            LeadingIndicatorFeignClient leadingIndicatorInvestingComPort
    ) {
        this.leadingIndicatorInvestingComPort = leadingIndicatorInvestingComPort;
    }

    @Override
    public Chart getCbConsumer() {
        return Chart.from(leadingIndicatorInvestingComPort.getCbConsumer());
    }

    @Override
    public Chart getPcePriceIndex() {
        return Chart.from(leadingIndicatorInvestingComPort.getPce());
    }

    @Override
    public Chart getPersonalIncome() {
        return Chart.from(leadingIndicatorInvestingComPort.getPersonalIncome());
    }

    @Override
    public Chart getRetailSales() {
        return Chart.from(leadingIndicatorInvestingComPort.getRetailSales());
    }

    @Override
    public Chart getNewHomeSales() {
        return Chart.from(leadingIndicatorInvestingComPort.getNewHomeSales());
    }

    @Override
    public Chart getExistingHomeSales() {
        return Chart.from(leadingIndicatorInvestingComPort.getExistingHomeSales());
    }

    @Override
    public Chart getAllCarSales() {
        return Chart.from(leadingIndicatorInvestingComPort.getAllCarSales());
    }

    @Override
    public Chart getIsmManufacturingPMI() {
        return Chart.from(leadingIndicatorInvestingComPort.getIsmManufacturingPMI());
    }

    @Override
    public Chart getManufacturingPMI() {
        return Chart.from(leadingIndicatorInvestingComPort.getManufacturingPMI());
    }
}