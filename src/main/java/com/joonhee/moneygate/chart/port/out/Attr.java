package com.joonhee.moneygate.chart.port.out;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Date;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Attr {
    private Date timestamp;
    private ActualState actualState;
    private double actual;
    private String actualFormatted;
    private double forecast;
    private String forecastFormatted;
    private double revised;
    private String revisedFormatted;

    public Date getTimestamp() {
        return timestamp;
    }

    public ActualState getActualState() {
        return actualState;
    }

    public double getActual() {
        return actual;
    }

    public String getActualFormatted() {
        return actualFormatted;
    }

    public double getForecast() {
        return forecast;
    }

    public String getForecastFormatted() {
        return forecastFormatted;
    }

    public double getRevised() {
        return revised;
    }

    public String getRevisedFormatted() {
        return revisedFormatted;
    }
}