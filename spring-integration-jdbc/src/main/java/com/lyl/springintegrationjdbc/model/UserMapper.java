package com.lyl.springintegrationjdbc.model;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ClassName UserMapper
 * Author liyunlong
 * Data 上午 10:45
 * Version 1.0
 **/
public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        return new User(resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("email"));
    }
}
