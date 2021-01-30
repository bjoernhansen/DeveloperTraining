package com.work.adler_142.material_composition;

public class UsageExample {

    public static void main(String[] args) {
        MaterialComposition materialComposition = new MaterialComposition();

        materialComposition.addFabricCategory(
                new FabricCategory("Oberstoff")
                        .addCompositionElement("Baumwolle", 100));

        materialComposition.addFabricCategory(
                new FabricCategory("Futter")
                        .addCompositionElement("Acetat", 98)
                        .addCompositionElement("Elasthan", 2));

        System.out.println(materialComposition.toString());
    }
}