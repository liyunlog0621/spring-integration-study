package com.lyl.springintegrationjdbc.model;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ClassName PersonMapper
 * Author liyunlong
 * Data 上午 10:45
 * Version 1.0
 **/
public class PersonMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();
        person.setPersonId(resultSet.getInt("personId"));
        person.setName(resultSet.getString("name"));
        person.setPassword(resultSet.getString("password"));
        person.setDateOfBirth(resultSet.getString("dateOfBirth"));
        return person;
    }
}
