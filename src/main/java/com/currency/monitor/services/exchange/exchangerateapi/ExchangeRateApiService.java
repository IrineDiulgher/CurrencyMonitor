package com.currency.monitor.services.exchange.exchangerateapi;

import com.currency.monitor.services.exchange.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ExchangeRateApiService implements ExchangeService {

    private static final String URL = "https://v6.exchangerate-api.com/v6/9d70b7f53da59b0a8ab6fcd9/latest/";

    @Value("${monitor.baseCurrency}")
    private String baseCurrency;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Map<String, Double> getExchangeRates() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<ExchangeRateApiResponse> responseEntity = restTemplate
                .exchange(URL + baseCurrency, HttpMethod.GET, entity, ExchangeRateApiResponse.class);

        return Objects.requireNonNull(responseEntity.getBody()).getExchangeRates().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> 1 / entry.getValue()));
    }

    @Override
    public String getBaseCurrency() {
        return baseCurrency;
    }
}
