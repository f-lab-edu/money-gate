package com.joonhee.moneygate.chart.service;

import com.joonhee.moneygate.chart.port.out.InflationIndicatorFeignClient;
import com.joonhee.moneygate.chart.usecase.InflationIndicator;
import com.joonhee.moneygate.chart.vo.EconomyChart;
import com.joonhee.moneygate.chart.vo.EconomyChartType;

public class InflationIndicatorProcessor implements InflationIndicator {
    private final InflationIndicatorFeignClient inflationIndicatorInvestingComPort;

    public InflationIndicatorProcessor(
        InflationIndicatorFeignClient inflationIndicatorInvestingComPort
    ) {
        this.inflationIndicatorInvestingComPort = inflationIndicatorInvestingComPort;
    }

    @Override
    public EconomyChart getCoreCpi() {
        return new EconomyChart(inflationIndicatorInvestingComPort.getCoreCpi(), EconomyChartType.CORE_CPI);
    }

    @Override
    public EconomyChart getCpi() {
        return new EconomyChart(inflationIndicatorInvestingComPort.getCpi(), EconomyChartType.CPI);
    }

    @Override
    public EconomyChart getCorePpi() {
        return new EconomyChart(inflationIndicatorInvestingComPort.getCorePpi(), EconomyChartType.PPI);
    }

    @Override
    public EconomyChart getEmploymentCostIndex() {
        return new EconomyChart(inflationIndicatorInvestingComPort.getEmploymentCostIndex(), EconomyChartType.EMPLOYMENT_COST_INDEX);
    }

    @Override
    public EconomyChart getAverageHourlyEarnings() {
        return new EconomyChart(inflationIndicatorInvestingComPort.getAverageHourlyEarnings(), EconomyChartType.AVERAGE_HOURLY_EARNINGS);
    }
}