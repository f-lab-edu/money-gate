package com.joonhee.moneygate.chart.service;

import com.joonhee.moneygate.chart.port.out.InflationIndicatorFeignClient;
import com.joonhee.moneygate.chart.vo.EconomyChart;
import com.joonhee.moneygate.chart.vo.EconomyChartType;
import org.springframework.stereotype.Service;

@Service
public class InflationIndicatorService {
    private final InflationIndicatorFeignClient inflationIndicatorInvestingComPort;

    public InflationIndicatorService(
        InflationIndicatorFeignClient inflationIndicatorInvestingComPort
    ) {
        this.inflationIndicatorInvestingComPort = inflationIndicatorInvestingComPort;
    }

    public EconomyChart getCoreCpi() {
        return new EconomyChart(inflationIndicatorInvestingComPort.getCoreCpi(), EconomyChartType.CORE_CPI);
    }

    public EconomyChart getCpi() {
        return new EconomyChart(inflationIndicatorInvestingComPort.getCpi(), EconomyChartType.CPI);
    }

    public EconomyChart getCorePpi() {
        return new EconomyChart(inflationIndicatorInvestingComPort.getCorePpi(), EconomyChartType.PPI);
    }

    public EconomyChart getEmploymentCostIndex() {
        return new EconomyChart(inflationIndicatorInvestingComPort.getEmploymentCostIndex(), EconomyChartType.EMPLOYMENT_COST_INDEX);
    }

    public EconomyChart getAverageHourlyEarnings() {
        return new EconomyChart(inflationIndicatorInvestingComPort.getAverageHourlyEarnings(), EconomyChartType.AVERAGE_HOURLY_EARNINGS);
    }
}