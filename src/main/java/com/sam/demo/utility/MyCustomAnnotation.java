package com.sam.demo.utility;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** Java Annotation
 * 
 * @author webwerks
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

public @interface MyCustomAnnotation {
 String name() default "";
}
