package com.joonhee.moneygate.chart.port.out;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Date;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Attr {
    public Date timestamp;
    public ActualState actualState;
    public double actual;
    public String actualFormatted;
    public double forecast;
    public String forecastFormatted;
    public double revised;
    public String revisedFormatted;
}