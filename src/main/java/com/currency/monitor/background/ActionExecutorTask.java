package com.currency.monitor.background;

import com.currency.monitor.entities.Alarm;

public class ActionExecutorTask implements Runnable {

    private final Alarm alarm;

    public ActionExecutorTask(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void run() {
        switch (alarm.getAction()) {
            case 1:
                sendEmail();
                break;
            case 2:
                sendSMS();
                break;
        }
    }

    private void sendEmail() {
        System.out.println("Sending email for " + alarm.getCurrency());
    }

    private void sendSMS() {
        System.out.println("Sending SMS for " + alarm.getCurrency());
    }

}
