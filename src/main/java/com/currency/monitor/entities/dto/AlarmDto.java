package com.currency.monitor.entities.dto;

import javax.validation.constraints.Pattern;

public class AlarmDto {

    @Pattern(regexp = "^([A-Z]{3})", message = "Invalid currency")
    private String currency;
    private double lowerExchangeRate;
    private double upperExchangeRate;

    public double getUpperExchangeRate() {
        return upperExchangeRate;
    }

    public void setUpperExchangeRate(double upperExchangeRate) {
        this.upperExchangeRate = upperExchangeRate;
    }

    public double getLowerExchangeRate() {
        return lowerExchangeRate;
    }

    public void setLowerExchangeRate(double lowerExchangeRate) {
        this.lowerExchangeRate = lowerExchangeRate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
