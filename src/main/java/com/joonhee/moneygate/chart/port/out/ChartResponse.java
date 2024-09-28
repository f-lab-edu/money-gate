package com.joonhee.moneygate.chart.port.out;

import lombok.Getter;

import java.util.List;
public class ChartResponse {
    private List<List<Object>> data;

    @Getter
    private List<Attr> attr;
}
