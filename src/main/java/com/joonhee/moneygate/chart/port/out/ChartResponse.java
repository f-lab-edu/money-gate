package com.joonhee.moneygate.chart.port.out;

import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;
@JsonNaming
public class ChartResponse {
    public List<List<Object>> data;
    public List<Attr> attr;
}
