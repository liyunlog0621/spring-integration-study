package com.lyl.springintegrationjdbc;

import com.lyl.springintegrationjdbc.model.Person;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName PersonService
 * Author liyunlong
 * Data 上午 10:45
 * Version 1.0
 */

@Component
public interface PersonService {

    Person createPerson(Person person);

    List<Person> findPersonByName(String name);
}
