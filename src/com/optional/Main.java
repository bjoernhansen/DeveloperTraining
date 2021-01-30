package com.optional;

import com.optional.model.Asset;
import com.optional.model.Feature;
import com.optional.model.Subfeature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {
        List<Asset> assets = getAssets();

        printAssetValues(assets, Main::getSubfeatureValue1, "mit flatmap wenn Optional als Rückgabe verwendet");
        printAssetValues(assets, Main::getSubfeatureValue2, "mit Hilfsfunktion applyIfNotNull");
        printAssetValues(assets, Main::getSubfeatureValue3, "Alternative");
        printAssetValues(assets, Main::getSubfeatureValue4, "Alternative");
        printAssetValues(assets, Main::getSubfeatureValueUgliest, "Old style before Java 8");
    }

    private static List<Asset> getAssets() {
        List<Asset> assets = new ArrayList<>();

        assets.add(null);
        assets.add(new Asset(null));
        assets.add(new Asset(new Feature(null)));
        assets.add(new Asset(new Feature(new Subfeature(null))));
        assets.add(new Asset(new Feature(new Subfeature("mySubfeatureValue"))));

        return assets;
    }

    private static void printAssetValues(List<Asset> assets, Function<Asset, String> function, String msg){
        System.out.println("\n" + msg);
        assets.stream()
              .map(function)
              .forEach(System.out::println);
    }

    private static String getSubfeatureValue1(Asset asset) {

        return Optional.ofNullable(asset)
                       .flatMap(Asset::getOptionalFeature)
                       .flatMap(Feature::getOptionalSubfeature)
                       .flatMap(Subfeature::getOptionalValue)
                       .orElse("kein Value");
    }

    private static String getSubfeatureValue2(Asset asset) {

        return Optional.ofNullable(asset)
                       .map(applyIfNotNull(Asset::getFeature))
                       .map(applyIfNotNull(Feature::getSubfeature))
                       .map(applyIfNotNull(Subfeature::getValue))
                       .orElse("kein Value");
    }

    public static <T, U> Function<T, U> applyIfNotNull(Function<T, U> mapper) {
        return t -> t != null ? mapper.apply(t) : null;
    }

    private static String getSubfeatureValue3(Asset asset) {

        return Stream.of(asset)
                     .map(Optional::ofNullable)
                     .map(a -> a.map(Asset::getFeature))
                     .map(feature -> feature.map(Feature::getSubfeature))
                     .map(subfeature -> subfeature.map(Subfeature::getValue))
                     .findFirst()
                     .get()
                     .orElse("kein Value");
    }

    private static String getSubfeatureValue4(Asset asset) {
        return Stream.of(asset)
                     .filter(Objects::nonNull)
                     .map(Asset::getFeature)
                     .filter(Objects::nonNull)
                     .map(Feature::getSubfeature)
                     .filter(Objects::nonNull)
                     .map(Subfeature::getValue)
                     .filter(Objects::nonNull)
                     .findFirst()
                     .orElse("kein Value");
    }

    private static String getSubfeatureValueUgliest(Asset asset) {
        if (asset != null) {
            Feature feature = asset.getFeature();
            if (feature != null) {
                Subfeature subfeature = feature.getSubfeature();
                if (subfeature != null) {
                    String value = subfeature.getValue();
                    if (value != null) {
                        return value;
                    }
                }
            }
        }
        return "kein value";
    }
}