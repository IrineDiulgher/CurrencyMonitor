package com.currency.monitor.services;

import com.currency.monitor.datasource.AlarmDAO;
import com.currency.monitor.entities.Alarm;
import com.currency.monitor.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AlarmsService {

    @Autowired
    private AlarmDAO alarmDAO;

    public List<Alarm> getAlarms() {
        return alarmDAO.findAll();
    }
    public List<Alarm> getAlarms(Long id) {
        return alarmDAO.findAllByUserId(id);
    }
    public void deleteByUserId(Long userId){
     alarmDAO.deleteAllByUserId(userId);
    }

    public Alarm createAlarm(String currency, double lowerExchangeRate, double upperExchangeRate, User user) {
        Alarm alarm = new Alarm();
        alarm.setCurrency(currency);
        alarm.setLowerExchangeRate(lowerExchangeRate);
        alarm.setUpperExchangeRate(upperExchangeRate);
        alarm.setAction(1);
        alarm.setAddedSince(new Date());
        alarm.setUser(user);
        System.out.println("id="+ user.getId());
        return alarmDAO.save(alarm);
    }

    public void deleteAlarm(long id) {
        alarmDAO.deleteById(id);
    }

}
