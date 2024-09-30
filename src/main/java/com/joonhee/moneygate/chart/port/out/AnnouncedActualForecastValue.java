package com.joonhee.moneygate.chart.port.out;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

import java.util.Date;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
public class AnnouncedActualForecastValue {
    private Date timestamp;
    private String actualState;
    private double actual;
    private String actualFormatted;
    private double forecast;
    private String forecastFormatted;
    private double revised;
    private String revisedFormatted;
}