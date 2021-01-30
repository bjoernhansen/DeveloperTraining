package com.work.adler_142.feature_helper;

import java.util.ArrayList;
import java.util.List;


public class NestedFeatureElement {

    private String featureKey;
    private String featureValue;

    private List<NestedFeatureElement> nestedFeatures = new ArrayList<>();


    public NestedFeatureElement(String featureKey) {
        this.featureKey = featureKey;
    }




}
