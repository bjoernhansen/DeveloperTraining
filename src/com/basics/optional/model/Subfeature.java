package com.basics.optional.model;

import java.util.Optional;


public class Subfeature {

    private String value;

    public Subfeature(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Optional<String> getOptionalValue() {
        return Optional.ofNullable(value);
    }
}