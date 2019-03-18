package com.resapi.project.res_api_project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="person")
public class Person implements Serializable {

    @Id

    private Long pid;
    @Column
    private String name;
    @Column
    private String surname;
    @Column(name = "email", nullable = false)
    private String email;

    private double amount;
    private Integer termInMonth;
    private Double rateDaily;

    @Column
    private String username;
    @Column
    @JsonIgnore
    private String password;

    public Person() {

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getAmount(double amount) {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Integer getTermInMonth(int i) {
        return termInMonth;
    }

    public void setTermInMonth(Integer termInMonth) {
        this.termInMonth = termInMonth;
    }

    public Double getRateDaily(double v) {
        return rateDaily;
    }

    public void setRateDaily(Double rateDaily) {
        this.rateDaily = rateDaily;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", amount='" + amount + '\'' +
                ", termInMonth='" + termInMonth + '\'' +
                ", rateDaily='" + rateDaily + '\'' +
                '}';
    }
}
