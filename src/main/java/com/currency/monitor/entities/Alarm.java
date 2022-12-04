package com.currency.monitor.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "alarms")
public class Alarm {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String currency;
    private double lowerExchangeRate;
    private double upperExchangeRate;
    private int action;
    private Date addedSince;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Alarm(Long id, String currency, double lowerExchangeRate, double upperExchangeRate, int action, Date addedSince) {
        this.id = id;
        this.currency = currency;
        this.lowerExchangeRate = lowerExchangeRate;
        this.upperExchangeRate = upperExchangeRate;
        this.action = action;
        this.addedSince = addedSince;
    }

    public Alarm() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getLowerExchangeRate() {
        return lowerExchangeRate;
    }

    public void setLowerExchangeRate(double lowerExchangeRate) {
        this.lowerExchangeRate = lowerExchangeRate;
    }

    public double getUpperExchangeRate() {
        return upperExchangeRate;
    }

    public void setUpperExchangeRate(double upperExchangeRate) {
        this.upperExchangeRate = upperExchangeRate;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public Date getAddedSince() {
        return addedSince;
    }

    public void setAddedSince(Date addedSince) {
        this.addedSince = addedSince;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
