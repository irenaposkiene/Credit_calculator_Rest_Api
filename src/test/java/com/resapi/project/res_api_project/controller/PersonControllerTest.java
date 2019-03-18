package com.resapi.project.res_api_project.controller;

import com.resapi.project.res_api_project.model.Person;
import com.resapi.project.res_api_project.service.PersonService;
import org.apache.maven.wagon.ConnectionException;
import org.hibernate.QueryException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Optional;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;


@RunWith(SpringJUnit4ClassRunner.class)

@WebAppConfiguration
public class PersonControllerTest {


    @Autowired
    private PersonService personService;


    @Test
    public void findAllPersons() throws ConnectionException, QueryException{
        Person person = new Person();
        person.setName("Tomas");
        person.setSurname("Tomauskas");
        person.setEmail("tomas@tomukas.lt");
        person.setAmount(5000.00);
        person.getRateDaily(2.00);
        person.getTermInMonth(24);

        personService.save(person);
        Assert.assertNotNull(personService.findOne(3L));
        Person person2 = new Person();

        person2 = personService.findOne(person.getPid());
        assertNotNull(person2);
        assertEquals("1", person2.getPid());




    }

}
