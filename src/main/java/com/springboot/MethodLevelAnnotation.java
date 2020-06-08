package com.springboot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A simple custom annotation
 * 
 * @author gopikrishhnachokkalamani
 *
 */
@Target(value = { ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodLevelAnnotation {

	/**
	 * Expression value for the Annotation
	 * 
	 * @return String
	 */
	String value() default "";

}
