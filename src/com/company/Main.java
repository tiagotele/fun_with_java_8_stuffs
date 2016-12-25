package com.company;

import java.util.*;

import static java.util.Comparator.comparing;

import java.util.UUID;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    private static Integer LIST_SIZE = 10;

    public static void main(String[] args) {

        List<Person> personsList = getPersons();

        personsList.forEach(u -> System.out.println(u));

//        Collections.sort(personsList, (per1, per2) -> per1.getName().compareTo(per2.getName()));
//        Collections.sort(personsList, (per1,per2) -> per1.getAge().compareTo(per2.getAge()));
//        Collections.sort(personsList, (per1, per2) -> per1.getAddress().getCountry().compareTo(per2.getAddress().getCountry()));
//        Collections.sort(personsList, comparing(u -> u.getName()));
        personsList.sort(comparing(Person::getName).reversed().thenComparing(Person::getAge));

        System.out.println("-----------------");
//        personsList.forEach(u -> System.out.println(u));
        personsList.forEach(System.out::println);

        //Filtering user age equals or older than 30 and make them moderators
        //My approach

//        List<Person> selectedPersons = new ArrayList<>();
//        for (Person person : personsList){
//            if(person.getAge() >= 30){
//                person.turnModerador();
//                selectedPersons.add(person);
//            }
//        }
//
//        System.out.println("--------------");
//        selectedPersons.forEach(System.out::println);

        //One best approach using streams
        System.out.println("--------------");
        personsList.stream().filter(person -> person.getAge() >= 30).forEach(System.out::println);

        //Playing with multiple filters
        System.out.println("--------------");
        personsList.stream().filter(person -> person.getAge() >= 20)
                .filter(person -> person.getAddress().getCountry().equals(Country.Germany))
                .forEach(System.out::println);


        System.out.println("--------------");
//        List<Person> olderThan30 = new ArrayList<>();
//
//        personsList.stream().filter(person -> person.getAge() >= 20).forEach(olderThan30::add);
//        olderThan30.forEach(System.out::println);
        List<Person> olderThan30 = personsList.stream().filter(person -> person.getAge() >= 30).collect(Collectors.toList());

        olderThan30.forEach(System.out::println);

        //Get countries each person
        System.out.println("--------------");
        List<Country> countries = personsList.stream().map(person -> person.getAddress().getCountry() ).collect(Collectors.toList());

        countries.forEach(System.out::println);

        //Get countries each person older than 40
        System.out.println("--------------");
        List<Country> countriesOld = personsList.stream()
                .filter(person -> person.getAge() >= 40)
                .map(person -> person.getAddress().getCountry())
                .collect(Collectors.toList());
        countriesOld.forEach(System.out::println);

        //Get average og ages for each person
        System.out.println("--------------");
        double averageAge = personsList.stream().mapToInt(Person::getAge).average().orElse(0.0);
        System.out.println(averageAge);

    }

    private static List<Person> getPersons() {

        List<Person> personsList = new ArrayList<>();
        for (int i = 0; i < LIST_SIZE; i++) {
            String street = UUID.randomUUID().toString();
            String postalCode = UUID.randomUUID().toString();
            String personName = UUID.randomUUID().toString();
            Random rand = new Random();
            Integer addressNumber = rand.nextInt(5000);
            Integer age = rand.nextInt(50);
            Integer countryIndex = rand.nextInt(3);
            Integer phoneNumber = rand.nextInt();
            Integer moderator = rand.nextInt(2);
            Boolean moderatorValue = moderator == 0 ? false : true;

            Country country = Country.values()[countryIndex];

            Address address = new Address(country, street, addressNumber, postalCode);
            Person person = new Person(personName, age, phoneNumber.toString(), address, moderatorValue);

            personsList.add(person);
        }


        return personsList;
    }
}
