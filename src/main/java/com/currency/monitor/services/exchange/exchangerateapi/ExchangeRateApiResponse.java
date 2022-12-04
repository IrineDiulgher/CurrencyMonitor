package com.currency.monitor.services.exchange.exchangerateapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.util.Map;

public class ExchangeRateApiResponse {

    @JsonProperty("result")
    public String result;
    @JsonProperty("conversion_rates")
    @JsonUnwrapped
    private Map<String, Double> exchangeRates;

    public ExchangeRateApiResponse() {

    }

    public Map<String, Double> getExchangeRates() {
        if (!result.equals("success"))
            throw new IllegalStateException("Failed to get exchange rates");
        return exchangeRates;
    }

    @Override
    public String toString() {
        return exchangeRates.toString();
    }
}
