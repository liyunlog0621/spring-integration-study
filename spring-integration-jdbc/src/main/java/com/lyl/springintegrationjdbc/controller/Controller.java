package com.lyl.springintegrationjdbc.controller;

import com.lyl.springintegrationjdbc.DateUtil;
import com.lyl.springintegrationjdbc.PersonService;
import com.lyl.springintegrationjdbc.model.Gender;
import com.lyl.springintegrationjdbc.model.Person;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName controller
 * Author liyunlong
 * Data 下午 2:25
 * Version 1.0
 **/
@RestController
public class Controller {

    private final PersonService personService;

    public Controller(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping("hello")
    public List<Person> helloWord(String name) {
        List<Person> personList = personService.findPersonByName(name);
        if (!personList.isEmpty()) {
            personList.forEach(p -> {
                System.out.println("personId:" + p.getPersonId());
                System.out.println("name:" + p.getName());
                System.out.println("password:" + p.getPassword());
                System.out.println("dateOfBirth:" + p.getDateOfBirth());
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            });
        }
        return personList;
    }

    @GetMapping("add")
    public String add(String name) {
        Person person = new Person();
        person.setPassword("123456");
        person.setName(name);
        person.setDateOfBirth(DateUtil.formate(new Date()));
        personService.createPerson(person);
        return "添加完毕";
    }
}
