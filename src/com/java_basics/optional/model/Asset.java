package com.java_basics.optional.model;

import java.util.Optional;


public class Asset {
    
    private Feature feature;

    public Asset(Feature feature) {
        this.feature = feature;
    }

    public Feature getFeature() {
        return feature;
    }

    public Optional<Feature> getOptionalFeature() {
        return Optional.ofNullable(feature);
    }
}