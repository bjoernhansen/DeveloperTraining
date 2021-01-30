package com.optional.model;

import java.util.Optional;


public class Asset {

    Feature feature;

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