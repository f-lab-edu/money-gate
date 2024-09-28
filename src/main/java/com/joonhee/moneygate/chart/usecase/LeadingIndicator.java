package com.joonhee.moneygate.chart.usecase;

import com.joonhee.moneygate.chart.vo.EconomyChart;

public interface LeadingIndicator {
    EconomyChart getCbConsumer();
    EconomyChart getPcePriceIndex();
    EconomyChart getPersonalIncome();
    EconomyChart getRetailSales();
    EconomyChart getNewHomeSales();
    EconomyChart getExistingHomeSales();
    EconomyChart getAllCarSales();
    EconomyChart getIsmManufacturingPMI();
    EconomyChart getManufacturingPMI();
}