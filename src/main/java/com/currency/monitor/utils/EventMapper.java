package com.currency.monitor.utils;

import com.currency.monitor.entities.Event;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventMapper implements RowMapper<Event> {

    @Override
    public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Event(rs.getLong("id"),
                rs.getString("currency"),
                rs.getDouble("exchangeRate"),
                rs.getDouble("lowerExchangeRate"),
                rs.getDouble("upperExchangeRate"),
                rs.getDate("timestamp"));
    }

}
