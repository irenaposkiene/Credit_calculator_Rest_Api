package com.resapi.project.res_api_project.service;

import com.resapi.project.res_api_project.model.Person;
import com.resapi.project.res_api_project.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


public interface PersonService {

    Person save(Person person);
    List<Person> findAll();
    Person findOne(long id);
    void delete(long id);
    void updatePerson(Person person);
}
