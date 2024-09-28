package com.joonhee.moneygate.chart.vo;

import com.joonhee.moneygate.chart.port.out.ActualState;
import com.joonhee.moneygate.chart.port.out.ChartResponse;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;


public class EconomyChart {
    private final EconomyChartType type;
    private List<IndicatorData> content;

    public EconomyChartType getType() {
        return type;
    }

    public List<IndicatorData> getContent() {
        return List.copyOf(content);
    }

    public class IndicatorData {
        private ActualState actualState;
        private Double actual;
        private String actualFormatted;
        private Double forecast;
        private String forecastFormatted;
        private Double previous;
        private String previousFormatted;
        private ZonedDateTime announcedAt;

        public IndicatorData(
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

    public EconomyChart(ChartResponse chartResponse, EconomyChartType economyChartType) {
        this.type = economyChartType;
        AtomicReference<Optional<IndicatorData>> previousData = new AtomicReference<>(null);

        this.content = chartResponse.getAttr().stream().map(attr -> {
            IndicatorData indicatorData = new IndicatorData(
                Optional.ofNullable(attr.getActualState()).orElse(null),
                Optional.ofNullable(attr.getActual()).orElse(null),
                Optional.ofNullable(attr.getActualFormatted()).orElse(null),
                Optional.ofNullable(attr.getForecast()).orElse(null),
                Optional.ofNullable(attr.getForecastFormatted()).orElse(null),
                previousData.get() != null ? previousData.get().orElseThrow().actual : null,
                previousData.get() != null ? previousData.get().orElseThrow().actualFormatted : null,
                Optional.ofNullable(attr.getTimestamp().toInstant().atZone(ZoneId.of("Asia/Seoul"))).orElse(null)
            );
            previousData.set(Optional.of(indicatorData));
            return indicatorData;
        }).collect(Collectors.toList());
    }
}