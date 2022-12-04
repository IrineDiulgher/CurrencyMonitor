package com.currency.monitor.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String currency;
    private double exchangeRate;
    private double lowerExchangeRate;
    private double upperExchangeRate;
    private Date timestamp;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Event(Long id, String currency, double exchangeRate, double lowerExchangeRate, double upperExchangeRate, Date timestamp) {
        this.id = id;
        this.currency = currency;
        this.exchangeRate = exchangeRate;
        this.lowerExchangeRate = lowerExchangeRate;
        this.upperExchangeRate = upperExchangeRate;
        this.timestamp = timestamp;
    }

    public Event() {

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

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
