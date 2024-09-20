package com.joonhee.moneygate.chart.port.out;

import java.util.List;
public class ChartResponse {
    private List<List<Object>> data;
    private List<Attr> attr;

    public List<Attr> getAttr() {
        return attr;
    }
}
