package com.currency.monitor.background;

import com.currency.monitor.services.AlarmsService;
import com.currency.monitor.services.EventsService;
import com.currency.monitor.services.exchange.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AlarmsCheckerImpl implements AlarmsChecker {

    @Autowired
    private AlarmsService alarmsService;

    @Autowired
    private EventsService eventsService;

    @Autowired
    private ExchangeService exchangeService;

    @Autowired
    private TaskScheduler taskScheduler;

    public AlarmsCheckerImpl() {

    }

    @Override
    public void run() {
        System.out.println("Running alarm checker...");
        Map<String, Double> exchangeRates = exchangeService.getExchangeRates();
        alarmsService.getAlarms().forEach(alarm -> {
            if (!exchangeRates.containsKey(alarm.getCurrency())) {
                return;
            }
            double exchangeRate = exchangeRates.get(alarm.getCurrency());
            boolean actionable = (alarm.getLowerExchangeRate() != 0 && alarm.getLowerExchangeRate() >= exchangeRate) ||
                    (alarm.getUpperExchangeRate() != 0 && alarm.getUpperExchangeRate() <= exchangeRate);
            if (actionable) {
                eventsService.createEvent(alarm.getCurrency(), exchangeRate, alarm.getLowerExchangeRate(), alarm.getUpperExchangeRate(),alarm.getUser());
                taskScheduler.schedule(new ActionExecutorTask(alarm), taskScheduler.getClock().instant().plusMillis(1000));
            }
        });
        System.out.println("Alarm checker completed!");
    }
}