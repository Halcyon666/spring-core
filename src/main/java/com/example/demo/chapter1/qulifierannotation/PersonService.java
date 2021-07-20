package com.example.demo.chapter1.qulifierannotation;

import org.springframework.beans.factory.annotation.Autowired;


public class PersonService {
    @Autowired
    @PersonQualifier(status = "Poor", quality = "Good")
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}