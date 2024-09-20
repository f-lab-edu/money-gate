package com.joonhee.moneygate.chart.vo;

import com.joonhee.moneygate.chart.port.out.ActualState;
import com.joonhee.moneygate.chart.port.out.ChartResponse;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
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
            this.previousFormatted = previousFormatted;
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
        AtomicReference<Optional<Data>> previousData = new AtomicReference<>(null);

        this.content = chartResponse.getAttr().stream().map(attr -> {
            Data data = new Data(
                    Optional.ofNullable(attr.getActualState()).orElse(null),
                    Optional.ofNullable(attr.getActual()).orElse(null),
                    Optional.ofNullable(attr.getActualFormatted()).orElse(null),
                    Optional.ofNullable(attr.getForecast()).orElse(null),
                    Optional.ofNullable(attr.getForecastFormatted()).orElse(null),
                    previousData.get() != null ? previousData.get().orElseThrow().actual : null,
                    previousData.get() != null ? previousData.get().orElseThrow().actualFormatted : null,
                    Optional.ofNullable(attr.getTimestamp().toInstant().atZone(ZoneId.of("Asia/Seoul"))).orElse(null)
            );
            previousData.set(Optional.of(data));
            return data;
        }).collect(Collectors.toList());
    }
}