package com.resapi.project.res_api_project.controller;

import com.resapi.project.res_api_project.model.Person;
import com.resapi.project.res_api_project.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons/")

@CrossOrigin("http://localhost:4200")

public class PersonController {


    @Autowired
    private PersonService personService;


    @RequestMapping(method= RequestMethod.GET, path="person")
    public List<Person> listPerson(){
        return personService.findAll();
    }

    @RequestMapping(method= RequestMethod.POST, path="addperson")
    public Person create(@RequestBody Person person){
        return personService.save(person);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/person/{pid}")
    public Person findOne(@PathVariable long id){
        return personService.findOne(id);
    }

    @RequestMapping( method = RequestMethod.PUT, value = "/person/{pid}")
    public Person update(@PathVariable long id, @RequestBody Person person){
        person.setPid(id);
        return personService.save(person);
    }

    @RequestMapping(value = "/person/{pid}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "pid") Long id){
        personService.delete(id);
    }

    @RequestMapping(method= RequestMethod.GET, path="/Credit/amount/{amount}/termInMonth/{termInMonth}/rateDaily/{rateDaily}")
    public String GetCredit(@PathVariable double amount,@PathVariable int termInMonth,@PathVariable double rateDaily){

        return String.format ("Customer has credit" + calculateCredit(amount,termInMonth,rateDaily));

    }

    public static double calculateCredit(
            double amount, int termInMonth, double rateDaily) {

        // Convert interest rate into a decimal

        rateDaily/= 100.0;

        // Monthly rate is the yearly rate divided by 12

        double monthlyRate = (rateDaily*30);

        // Calculate the monthly credit

        double credit =
                (amount*monthlyRate) /
                        (1-Math.pow(1+monthlyRate, -termInMonth));

        return credit;
    }


}
