package com.resapi.project.res_api_project.service;

import com.resapi.project.res_api_project.model.Person;
import com.resapi.project.res_api_project.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

@Service(value = "personService")
public class PersonServiceImpl implements UserDetailsService, PersonService {

    @Autowired
    private PersonRepository personRepository ;
    private String userId;

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> findAll() {
        List<Person> list = new ArrayList<>();
        personRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Person findOne(long pid) {
        return personRepository.findById(pid).get();
    }


    @Override
    public void delete(long pid) {
        personRepository.deleteById(pid);
    }

    @Override
    public void updatePerson(Person person) {
        personRepository.save(person);

    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Person person = personRepository.findByUsername(userId);
        if(person == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(person.getUsername(), person.getPassword(), getAuthority());

    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

}
