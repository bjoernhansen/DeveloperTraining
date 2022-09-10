package com.java_basics.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // zu Laufzeit "lesbar"
@Target(value = {ElementType.TYPE}) // nur für Klassen
@interface ReleaseVersion
{
    String value();     //ReleaseVersion("1.1.0"):
}
