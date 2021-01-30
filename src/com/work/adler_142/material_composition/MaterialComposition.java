package com.work.adler_142.material_composition;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class MaterialComposition {
    private List<FabricCategory> fabricCategories = new ArrayList<>();

    public void addFabricCategory(FabricCategory fabricCategory) {
        fabricCategories.add(fabricCategory);
    }

    // e.g. Oberstoff: 100% Baumwolle|Futter: 98% Acetat, 2% Elasthan
    public String toString() {
        StringJoiner joinedCategories = new StringJoiner("|");
        for(FabricCategory fabricCategory : fabricCategories) {
            joinedCategories.add(fabricCategory.toString());
        }
        return joinedCategories.toString();
    }
}