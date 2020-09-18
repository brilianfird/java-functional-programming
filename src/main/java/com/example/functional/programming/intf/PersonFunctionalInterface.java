package com.example.functional.programming.intf;

import com.example.functional.programming.model.Person;

@FunctionalInterface
public interface PersonFunctionalInterface {

    Person createPerson(String name);

    default String getDefaultMethodString() {
        return "Default Method";
    }
}
