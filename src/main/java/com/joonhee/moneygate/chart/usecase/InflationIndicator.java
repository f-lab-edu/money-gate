package com.joonhee.moneygate.chart.usecase;

import com.joonhee.moneygate.chart.vo.Chart;

public interface InflationIndicator {
    Chart getCoreCpi();
    Chart getCpi();
    Chart getCorePpi();
    Chart getEmploymentCostIndex();
    Chart getAverageHourlyEarnings();
}
