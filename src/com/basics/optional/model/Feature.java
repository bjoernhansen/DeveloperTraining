package com.basics.optional.model;

import java.util.Optional;


public class Feature {

    private Subfeature subfeature;

    public Feature(Subfeature subfeature) {
        this.subfeature = subfeature;
    }

    public Subfeature getSubfeature() {
        return subfeature;
    }

    public Optional<Subfeature> getOptionalSubfeature() {
        return Optional.ofNullable(subfeature);
    }
}
