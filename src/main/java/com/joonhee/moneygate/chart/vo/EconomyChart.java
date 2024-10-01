package com.joonhee.moneygate.chart.vo;

import com.joonhee.moneygate.chart.port.out.InvestingComChartResponse;
import lombok.Getter;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Getter
public class EconomyChart {
    private final EconomyChartType type;
    private List<IndicatorData> content;

    @Getter
    public class IndicatorData {
        private CompareActualToForecastStatus compareActualToForecastStatus;
        private Double actual;
        private String actualFormatted;
        private Double forecast;
        private String forecastFormatted;
        private Double previous;
        private String previousFormatted;
        private ZonedDateTime announcedAt;

        public IndicatorData(
            CompareActualToForecastStatus compareActualToForecastStatus,
            Double actual,
            String actualFormatted,
            Double forecast,
            String forecastFormatted,
            Double previous,
            String previousFormatted,
            ZonedDateTime announcedAt
        ) {
            this.compareActualToForecastStatus = compareActualToForecastStatus;
            this.actual = actual;
            this.actualFormatted = actualFormatted;
            this.forecast = forecast;
            this.forecastFormatted = forecastFormatted;
            this.previous = previous;
            this.previousFormatted = previousFormatted;
            this.announcedAt = announcedAt;
        }
    }

    public EconomyChart(InvestingComChartResponse investingComChartResponse, EconomyChartType economyChartType) {
        this.type = economyChartType;
        AtomicReference<Optional<IndicatorData>> previousData = new AtomicReference<>(null);

        this.content = investingComChartResponse.getAttr().stream().map(attr -> {

            IndicatorData indicatorData = new IndicatorData(
                Optional.ofNullable(CompareActualToForecastStatus.from(attr.getActualState())).orElse(null),
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