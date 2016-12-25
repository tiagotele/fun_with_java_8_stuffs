package com.company;

/**
 * Created by Tiago on 12/22/16.
 */
public enum Country {
    Brazil("Brazil"),
    Germany("Germany"),
    USA("United States");

    private final String country;

    Country(final String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return country;
    }
}
