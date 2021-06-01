package com.basics.Strings;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;


class NumberFromStringExtractor {

    private static final Pattern PATTERN = Pattern.compile(".+_([0-9]+)\\..+");

    static String getSapidFromFilenameBjoern(String val) {
        return Stream.of(val.split("\\."))
                     .findFirst()
                     .map(s -> s.split("_"))
                     .map(array -> array[array.length - 1])
                     .filter(NumberFromStringExtractor::isNumeric)
                     .orElse("0");
    }

    static String getSapidFromFilenameJannes(String val) {
        if (val == null) {
            // maybe log warning/error?
            return "0";
        }
        var dotIndex = val.lastIndexOf('.');
        var withoutFileExtension = val.substring(0, dotIndex > -1 ? dotIndex : val.length());
        var underscoreIndex = withoutFileExtension.lastIndexOf('_');
        if (underscoreIndex == -1) {
            // val might be == sapId, but we cannot be certain, so return 0
            // maybe log warning/error?
            return "0";
        }
        var sapId = withoutFileExtension.substring(underscoreIndex);
        if (isNumeric(sapId)) {
            return sapId;
        } else {
            return "0";
        }
    }

    static String getSapidFromFilenameSven(String val) {
        String ret = "0";
        if (hasNoValue(val)) {
            return ret;
        }
        String[] sourceWords = val.split("\\.");
        String temp = sourceWords[0];
        sourceWords = temp.split("_");
        for (String sourceWord : sourceWords) {
            ret = sourceWord;
        }
        if (!isNumeric(ret)) {
            return "0";
        }
        return ret;
    }

    static String getSapidFromFilenameUwe(String val) {
        String ret = "-1";
        if (val == null) {
            ret = "0";
        }
        Matcher matcher = PATTERN.matcher(Objects.requireNonNull(val));
        if (matcher.find()) {
            ret = matcher.group(1);
        }
        if (!isNumeric(ret)) {
            return ret;
        }
        return ret;
    }

    private static boolean hasNoValue(final String val) {
        return !hasValue(val);
    }

    private static boolean hasValue(final String val) {
        return val != null && !val.isEmpty();
    }

    private static boolean isNumeric(final String str) {
        if (str == null) {
            return false;
        }
        for (int i = str.length() - 1; i >= 0; i--) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}