package com.joonhee.moneygate.chart.service;

import com.joonhee.moneygate.chart.port.out.InflationIndicatorFeignClient;
import com.joonhee.moneygate.chart.usecase.InflationIndicator;
import com.joonhee.moneygate.chart.vo.Chart;

public class InflationIndicatorProcessor implements InflationIndicator {
    private final InflationIndicatorFeignClient inflationIndicatorInvestingComPort;

    public InflationIndicatorProcessor(
            InflationIndicatorFeignClient inflationIndicatorInvestingComPort
    ) {
        this.inflationIndicatorInvestingComPort = inflationIndicatorInvestingComPort;
    }

    @Override
    public Chart getCoreCpi() {
        return new Chart(inflationIndicatorInvestingComPort.getCoreCpi());
    }

    @Override
    public Chart getCpi() {
        return new Chart(inflationIndicatorInvestingComPort.getCpi());
    }

    @Override
    public Chart getCorePpi() {
        return new Chart(inflationIndicatorInvestingComPort.getCorePpi());
    }

    @Override
    public Chart getEmploymentCostIndex() {
        return new Chart(inflationIndicatorInvestingComPort.getEmploymentCostIndex());
    }

    @Override
    public Chart getAverageHourlyEarnings() {
        return new Chart(inflationIndicatorInvestingComPort.getAverageHourlyEarnings());
    }
}