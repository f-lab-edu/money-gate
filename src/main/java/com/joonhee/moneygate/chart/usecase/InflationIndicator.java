package com.joonhee.moneygate.chart.usecase;

import com.joonhee.moneygate.chart.vo.EconomyChart;

public interface InflationIndicator {
    EconomyChart getCoreCpi();
    EconomyChart getCpi();
    EconomyChart getCorePpi();
    EconomyChart getEmploymentCostIndex();
    EconomyChart getAverageHourlyEarnings();
}
