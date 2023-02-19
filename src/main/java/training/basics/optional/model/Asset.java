package training.basics.optional.model;

import java.util.Optional;


public class Asset {
    
    private final Feature feature;

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