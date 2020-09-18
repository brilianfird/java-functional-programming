package com.example.functional.programming.model;

public class Person {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    public static Person createClassExampleFromMethodReference(String name) {
        return new Person(name);
    }
}
