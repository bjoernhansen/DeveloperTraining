package com.java_basics.annotation.cimdata;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/* Annotation mit 3 Attributen
 * Datentypen: String[], Class, annotation
 */

@Retention(RUNTIME)
@Target({ METHOD, FIELD })
@interface TestAnnotation
{
    String [] stringArray() default { "" };
    Class<?> klasse();
    ReleaseVersion rv() default @ReleaseVersion("0.1");
}
