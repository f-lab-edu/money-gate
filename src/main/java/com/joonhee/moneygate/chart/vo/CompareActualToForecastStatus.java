package com.joonhee.moneygate.chart.vo;

public enum CompareActualToForecastStatus {
    UP,
    DOWN,
    NEUTRAL;

    public static CompareActualToForecastStatus from(String value) {
        return valueOf(value.toUpperCase());
    }
}
