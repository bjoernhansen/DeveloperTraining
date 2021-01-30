package com.work.adler_142.material_composition;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class FabricCategory {

    private final String name;
    private List<CompositionElement> compositionElements = new ArrayList<>();


    public FabricCategory(String name) {
        this.name = name;
    }

    public FabricCategory addCompositionElement(String material, int percentage){
        compositionElements.add(new CompositionElement(material, percentage));
        return this;
    }

    // e.g. Futter: 98% Acetat, 2% Elasthan      oder 100% Baumwolle
    @Override
    public String toString() {
        StringJoiner joinedElements = new StringJoiner(", ");

        for(CompositionElement compositionElement : compositionElements) {
            joinedElements.add(compositionElement.toString());
        }

        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder
                .append(name)
                .append(": ")
                .append(joinedElements.toString())
                .toString();
    }
}