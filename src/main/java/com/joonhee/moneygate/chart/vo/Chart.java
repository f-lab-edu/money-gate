package com.joonhee.moneygate.chart.vo;

import com.joonhee.moneygate.chart.port.out.ActualState;
import com.joonhee.moneygate.chart.port.out.ChartResponse;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class Chart {
    private List<Data> content;

    public List<Data> getContent() {
        return List.copyOf(content);
    }

    public class Data {
        private ActualState actualState;
        private Double actual;
        private String actualFormatted;
        private Double forecast;
        private String forecastFormatted;
        private Double previous;
        private String previousFormatted;
        private ZonedDateTime announcedAt;

        public Data(
                ActualState actualState,
                Double actual,
                String actualFormatted,
                Double forecast,
                String forecastFormatted,
                Double previous,
                String previousFormatted,
                ZonedDateTime announcedAt
        ) {
            this.actualState = actualState;
            this.actual = actual;
            this.actualFormatted = actualFormatted;
            this.forecast = forecast;
            this.forecastFormatted = forecastFormatted;
            this.previous = previous;
            this.announcedAt = announcedAt;
        }

        public ActualState getActualState() {
            return actualState;
        }

        public Double getActual() {
            return actual;
        }

        public String getActualFormatted() {
            return actualFormatted;
        }

        public Double getForecast() {
            return forecast;
        }

        public String getForecastFormatted() {
            return forecastFormatted;
        }

        public Double getPrevious() {
            return previous;
        }

        public String getPreviousFormatted() {
            return previousFormatted;
        }

        public ZonedDateTime getAnnouncedAt() {
            return announcedAt;
        }
    }

    public Chart(ChartResponse chartResponse) {
        this.content = chartResponse.attr.stream().map(attr -> {
            Data data = new Data(
                    Optional.ofNullable(attr.actualState).orElse(null),
                    Optional.ofNullable(attr.actual).orElse(null),
                    Optional.ofNullable(attr.actualFormatted).orElse(null),
                    Optional.ofNullable(attr.forecast).orElse(null),
                    Optional.ofNullable(attr.forecastFormatted).orElse(null),
                    Optional.ofNullable(attr.revised).orElse(null),
                    Optional.ofNullable(attr.revisedFormatted).orElse(null),
                    Optional.ofNullable(attr.timestamp.toInstant().atZone(ZoneId.of("Asia/Seoul"))).orElse(null)
            );
            return data;
        }).collect(Collectors.toList());
    }
}

enum ChartType {
    LEADING_INDICATOR,
    INFLATION_INDICATOR
}