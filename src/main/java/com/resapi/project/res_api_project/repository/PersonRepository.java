package com.resapi.project.res_api_project.repository;

import com.resapi.project.res_api_project.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    Person findByUsername(String username);
}
