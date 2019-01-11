package com.lyl.springintegrationjdbc.model;

import java.util.Date;

/**
 * ClassName Person
 * Author liyunlong
 * Data 上午 10:44
 * Version 1.0
 **/
public class Person {

    private int personId;
    private String name;
    private Gender gender;
    private Date dateOfBirth;

    public Person() {
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
