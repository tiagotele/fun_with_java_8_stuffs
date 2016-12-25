package com.company;

/**
 * Created by Tiago on 12/22/16.
 */
public class Person {
    private String name;
    private Integer age;
    private String phone;
    private Address address;
    private Boolean moderador;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Boolean getModerador() {
        return moderador;
    }

    public void turnModerador() {
        this.moderador = true;
    }

    public Person(String name, Integer age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = new Address();
        this.moderador = false;
    }

    public Person(String name, Integer age, String phone, Address address) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.moderador = false;
    }

    public Person(String name, Integer age, String phone, Address address, Boolean moderador) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.moderador = moderador;
    }

    @Override
    public String toString() {
        return "Name = " + name + ",age = " + age + ",phone = " + phone + ",addres = " + address + ", moderator = " + moderador;
    }
}
