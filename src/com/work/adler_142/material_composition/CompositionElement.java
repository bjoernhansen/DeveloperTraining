package com.work.adler_142.material_composition;

class CompositionElement {

    private final String material;
    private final int percentage;

    CompositionElement(String material, int percentage) {
        this.material = material;
        this.percentage = percentage;
    }

    // e.g.: 2% Elasthan
    @Override
    public String toString() {
        return String.format("%d%% %s", percentage, material);
    }
}