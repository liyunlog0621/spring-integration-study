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
        person.setPersonId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));
        person.setGender(Gender.getGenderByIdentifier(resultSet.getString("gender")));
        person.setDateOfBirth(resultSet.getDate("dateOfBirth"));
        return person;
    }
}
