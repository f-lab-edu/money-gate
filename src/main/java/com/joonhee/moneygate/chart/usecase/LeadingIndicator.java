package com.joonhee.moneygate.chart.usecase;

import com.joonhee.moneygate.chart.vo.Chart;

public interface LeadingIndicator {
    Chart getCbConsumer();
    Chart getPcePriceIndex();
    Chart getPersonalIncome();
    Chart getRetailSales();
    Chart getNewHomeSales();
    Chart getExistingHomeSales();
    Chart getAllCarSales();
    Chart getIsmManufacturingPMI();
    Chart getManufacturingPMI();
}