package com.currency.monitor.utils;

import com.currency.monitor.entities.Alarm;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AlarmMapper implements RowMapper<Alarm> {

    @Override
    public Alarm mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Alarm(rs.getLong("id"),
                rs.getString("currency"),
                rs.getDouble("lowerExchangeRate"),
                rs.getDouble("upperExchangeRate"),
                rs.getInt("action"),
                rs.getDate("addedSince"));
    }

}
