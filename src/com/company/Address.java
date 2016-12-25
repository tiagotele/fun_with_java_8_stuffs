package com.company;

/**
 * Created by Tiago on 12/22/16.
 */
public class Address {

    private Country country;
    private String street;
    private Integer number;
    private String postalCode;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Address() {
        this.country = Country.Brazil;
        this.street = "";
        this.number = 0;
        this.postalCode = "";
    }

    public Address(Country country, String street, Integer number, String postalCode) {
        this.country = country;
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "[Country = " + country + ",street = " + street + ",postal code = " + postalCode + "";
    }
}
