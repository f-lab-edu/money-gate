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
        return Chart.from(inflationIndicatorInvestingComPort.getCoreCpi());
    }

    @Override
    public Chart getCpi() {
        return Chart.from(inflationIndicatorInvestingComPort.getCpi());
    }

    @Override
    public Chart getCorePpi() {
        return Chart.from(inflationIndicatorInvestingComPort.getCorePpi());
    }

    @Override
    public Chart getEmploymentCostIndex() {
        return Chart.from(inflationIndicatorInvestingComPort.getEmploymentCostIndex());
    }

    @Override
    public Chart getAverageHourlyEarnings() {
        return Chart.from(inflationIndicatorInvestingComPort.getAverageHourlyEarnings());
    }
}