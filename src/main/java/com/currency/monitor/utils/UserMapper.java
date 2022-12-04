package com.currency.monitor.utils;

import com.currency.monitor.entities.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(rs.getLong("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("phoneNumber"),
                rs.getString("email"),
                rs.getDate("memberSince"));
    }

}
