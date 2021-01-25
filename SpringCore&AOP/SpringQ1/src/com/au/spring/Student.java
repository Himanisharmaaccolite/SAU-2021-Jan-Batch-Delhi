package com.au.spring;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
public class Student {
    public Map<String, Person> getPerson() {
        return person;
    }

    public void setPerson(Map<String, Person> person) {
        this.person = person;
    }

    public Map<String,Person> person;

    public void show () {
        for (Person i : person.values()) {
            System.out.println(i.getAddress()+" "+i.getName()+" "+i.getAge());
        }
    }

    }

