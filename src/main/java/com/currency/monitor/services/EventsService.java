package com.currency.monitor.services;

import com.currency.monitor.datasource.EventDAO;
import com.currency.monitor.entities.Event;
import com.currency.monitor.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventsService {

    @Autowired
    private EventDAO eventDAO;

    public List<Event> getEvents(long id) {
        return eventDAO.findAllByUserId(id);
    }

    public void createEvent(String currency, double exchangeRate, double lowerExchangeRate, double upperExchangeRate, User user) {
        Event event = new Event();
        event.setCurrency(currency);
        event.setExchangeRate(exchangeRate);
        event.setLowerExchangeRate(lowerExchangeRate);
        event.setUpperExchangeRate(upperExchangeRate);
        event.setTimestamp(new Date());
        event.setUser(user);
        eventDAO.save(event);
    }

    public void deleteByUserId(Long id){
        eventDAO.deleteAllByUserId(id);
    }

    public void deleteEvent(long id) {
        eventDAO.deleteById(id);
    }

}
