package com.joonhee.moneygate.chart.service;

import com.joonhee.moneygate.chart.port.out.LeadingIndicatorFeignClient;
import com.joonhee.moneygate.chart.vo.EconomyChart;
import com.joonhee.moneygate.chart.vo.EconomyChartType;
import org.springframework.stereotype.Service;

@Service
public class LeadingIndicatorService {
    private final LeadingIndicatorFeignClient leadingIndicatorInvestingComPort;

    public LeadingIndicatorService(
        LeadingIndicatorFeignClient leadingIndicatorInvestingComPort
    ) {
        this.leadingIndicatorInvestingComPort = leadingIndicatorInvestingComPort;
    }

    public EconomyChart getCbConsumer() {
        return new EconomyChart(leadingIndicatorInvestingComPort.getCbConsumer(), EconomyChartType.CB_CONSUMER);
    }

    public EconomyChart getPcePriceIndex() {
        return new EconomyChart(leadingIndicatorInvestingComPort.getPce(), EconomyChartType.PCE);
    }

    public EconomyChart getPersonalIncome() {
        return new EconomyChart(leadingIndicatorInvestingComPort.getPersonalIncome(), EconomyChartType.PERSONAL_INCOME);
    }

    public EconomyChart getRetailSales() {
        return new EconomyChart(leadingIndicatorInvestingComPort.getRetailSales(), EconomyChartType.RETAIL_SALES);
    }

    public EconomyChart getNewHomeSales() {
        return new EconomyChart(leadingIndicatorInvestingComPort.getNewHomeSales(), EconomyChartType.NEW_HOME_SALES);
    }

    public EconomyChart getExistingHomeSales() {
        return new EconomyChart(leadingIndicatorInvestingComPort.getExistingHomeSales(), EconomyChartType.EXISTING_HOME_SALES);
    }

    public EconomyChart getAllCarSales() {
        return new EconomyChart(leadingIndicatorInvestingComPort.getAllCarSales(), EconomyChartType.ALL_CAR_SALES);
    }

    public EconomyChart getIsmManufacturingPMI() {
        return new EconomyChart(leadingIndicatorInvestingComPort.getIsmManufacturingPMI(), EconomyChartType.ISM_MANUFACTURING_PMI);
    }

    public EconomyChart getManufacturingPMI() {
        return new EconomyChart(leadingIndicatorInvestingComPort.getManufacturingPMI(), EconomyChartType.MANUFACTURING_PMI);
    }
}