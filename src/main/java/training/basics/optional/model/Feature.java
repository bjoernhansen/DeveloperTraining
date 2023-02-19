package training.basics.optional.model;

import java.util.Optional;


public class Feature {

    private final Subfeature subfeature;

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
