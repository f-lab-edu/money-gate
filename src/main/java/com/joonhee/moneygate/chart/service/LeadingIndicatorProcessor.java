package com.joonhee.moneygate.chart.service;

import com.joonhee.moneygate.chart.port.out.LeadingIndicatorFeignClient;
import com.joonhee.moneygate.chart.usecase.LeadingIndicator;
import com.joonhee.moneygate.chart.vo.EconomyChart;
import com.joonhee.moneygate.chart.vo.EconomyChartType;

public class LeadingIndicatorProcessor implements LeadingIndicator {
    private final LeadingIndicatorFeignClient leadingIndicatorInvestingComPort;

    public LeadingIndicatorProcessor(
            LeadingIndicatorFeignClient leadingIndicatorInvestingComPort
    ) {
        this.leadingIndicatorInvestingComPort = leadingIndicatorInvestingComPort;
    }

    @Override
    public EconomyChart getCbConsumer() {
        return new EconomyChart(leadingIndicatorInvestingComPort.getCbConsumer(), EconomyChartType.CB_CONSUMER);
    }

    @Override
    public EconomyChart getPcePriceIndex() {
        return new EconomyChart(leadingIndicatorInvestingComPort.getPce(), EconomyChartType.PCE);
    }

    @Override
    public EconomyChart getPersonalIncome() {
        return new EconomyChart(leadingIndicatorInvestingComPort.getPersonalIncome(), EconomyChartType.PERSONAL_INCOME);
    }

    @Override
    public EconomyChart getRetailSales() {
        return new EconomyChart(leadingIndicatorInvestingComPort.getRetailSales(), EconomyChartType.RETAIL_SALES);
    }

    @Override
    public EconomyChart getNewHomeSales() {
        return new EconomyChart(leadingIndicatorInvestingComPort.getNewHomeSales(), EconomyChartType.NEW_HOME_SALES);
    }

    @Override
    public EconomyChart getExistingHomeSales() {
        return new EconomyChart(leadingIndicatorInvestingComPort.getExistingHomeSales(), EconomyChartType.EXISTING_HOME_SALES);
    }

    @Override
    public EconomyChart getAllCarSales() {
        return new EconomyChart(leadingIndicatorInvestingComPort.getAllCarSales(), EconomyChartType.ALL_CAR_SALES);
    }

    @Override
    public EconomyChart getIsmManufacturingPMI() {
        return new EconomyChart(leadingIndicatorInvestingComPort.getIsmManufacturingPMI(), EconomyChartType.ISM_MANUFACTURING_PMI);
    }

    @Override
    public EconomyChart getManufacturingPMI() {
        return new EconomyChart(leadingIndicatorInvestingComPort.getManufacturingPMI(), EconomyChartType.MANUFACTURING_PMI);
    }
}