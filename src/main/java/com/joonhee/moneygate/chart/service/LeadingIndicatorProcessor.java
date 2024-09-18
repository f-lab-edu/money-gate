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
        return new Chart(leadingIndicatorInvestingComPort.getCbConsumer());
    }

    @Override
    public Chart getPcePriceIndex() {
        return new Chart(leadingIndicatorInvestingComPort.getPce());
    }

    @Override
    public Chart getPersonalIncome() {
        return new Chart(leadingIndicatorInvestingComPort.getPersonalIncome());
    }

    @Override
    public Chart getRetailSales() {
        return new Chart(leadingIndicatorInvestingComPort.getRetailSales());
    }

    @Override
    public Chart getNewHomeSales() {
        return new Chart(leadingIndicatorInvestingComPort.getNewHomeSales());
    }

    @Override
    public Chart getExistingHomeSales() {
        return new Chart(leadingIndicatorInvestingComPort.getExistingHomeSales());
    }

    @Override
    public Chart getAllCarSales() {
        return new Chart(leadingIndicatorInvestingComPort.getAllCarSales());
    }

    @Override
    public Chart getIsmManufacturingPMI() {
        return new Chart(leadingIndicatorInvestingComPort.getIsmManufacturingPMI());
    }

    @Override
    public Chart getManufacturingPMI() {
        return new Chart(leadingIndicatorInvestingComPort.getManufacturingPMI());
    }
}