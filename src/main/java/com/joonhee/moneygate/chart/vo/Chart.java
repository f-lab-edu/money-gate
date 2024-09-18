package com.joonhee.moneygate.chart.vo;

import com.joonhee.moneygate.chart.port.out.Attr;
import com.joonhee.moneygate.chart.port.out.ChartResponse;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Chart {
    private List<Data> data;
    private List<Attr> attr;


    public Chart(
            List<Data> data,
            List<Attr> attr
    ) {
        this.data = data;
        this.attr = attr;
    }

    public List<Data> getData() {
        return List.copyOf(data);
    }

    public List<Attr> getAttr() {
        return List.copyOf(attr);
    }

    static public class Data {
        private Long value;
        private Double percent;

        public Data(Long value, Double percent) {
            this.value = value;
            this.percent = percent;
        }

        public Long getValue() {
            return value;
        }

        public Double getPercent() {
            return percent;
        }
    }

    public static Chart from(ChartResponse chartResponse) {
        try {

            return new Chart(
                    chartResponse.data.stream()
                            .map(data ->
                                    new Data(
                                            Optional.ofNullable(data.get(0)).map(o -> (Long) o).orElseThrow(null),
                                            Optional.ofNullable(data.get(1)).map(o -> Double.valueOf(o.toString())).orElseThrow()
                                    ))
                            .collect(Collectors.toList()
                            ),
                    chartResponse.attr
            );
        } catch (Exception e) {
            return null;
        }

    }
}