package com.currency.monitor.services.exchange;

import java.util.Map;

public interface ExchangeService {

    Map<String, Double> getExchangeRates();

    String getBaseCurrency();

}
