package com.example.functional.programming;

import com.example.functional.programming.model.Person;
import com.example.functional.programming.intf.PersonFunctionalInterface;
import com.example.functional.programming.model.SimpleStream;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

class FunctionalApplicationTests {


    @Test
    void interfaceExample() {
        PersonFunctionalInterface normalAnonymousClass = new PersonFunctionalInterface() { // create normal anonymous class
            @Override
            public Person createPerson(String name) {
                return new Person(name);
            }
        };

        PersonFunctionalInterface interfaceExampleLambda =
                name -> new Person(name); // create anonymous class by lambda
        PersonFunctionalInterface interfaceExampleMethodReference =
                Person::createClassExampleFromMethodReference; // create anonymous class by method reference
        PersonFunctionalInterface interfaceExampleConstructorReference =
                Person::new; // create anonymous class by constructor reference

        // assert that every anonymous class behave the same
        assert(normalAnonymousClass
                .createPerson("Hello, World").getName().equals("Hello, World"));
        assert(interfaceExampleLambda
                .createPerson("Hello, World").getName().equals("Hello, World"));
        assert(interfaceExampleMethodReference
                .createPerson("Hello, World").getName().equals("Hello, World"));
        assert(interfaceExampleConstructorReference
                .createPerson("Hello, World").getName().equals("Hello, World"));
        assert(normalAnonymousClass.getDefaultMethodString().equals("Default Method"));
        assert(interfaceExampleLambda.getDefaultMethodString().equals("Default Method"));
        assert(interfaceExampleMethodReference.getDefaultMethodString().equals("Default Method"));
        assert(interfaceExampleConstructorReference.getDefaultMethodString().equals("Default Method"));
    }

    @Test
    void commonFunctionalInterface() {
        Stream.of("Hello", "World", "How", "Are", "you")
                .filter(s -> s.equals("Hello") || s.equals("Are"))
                .map(s -> s + " String")
                .forEach(System.out::println);

        Optional.of("Hello")
                .filter(s -> s.equals("Hello") || s.equals("Are"))
                .map(s -> s + " String")
                .ifPresent(System.out::println);
    }

    @Test
    void implementingFunctionalInterface() {
        List<String> stringsFromSimpleStream = new SimpleStream<>("Hello", "World", "How", "Are", "you")
                .filter(s -> s.equals("Hello") || s.equals("Are"))
                .map(s -> s + " String")
                .toList();

        assert(stringsFromSimpleStream.size() == 2);
        assert(stringsFromSimpleStream.get(0).equals("Hello String"));
        assert(stringsFromSimpleStream.get(1).equals("Are String"));

        new SimpleStream<>(stringsFromSimpleStream)
                .forEach(System.out::println);
    }

}
