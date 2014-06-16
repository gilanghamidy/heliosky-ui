package com.heliosky.toolkit.ui;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to set the field as Widget Reference. The parameter of the
 * annotation must be an Android R.id value.
 * 
 * @author Gilang Mentari Hamidy
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface WidgetReference {
	public int value();
}
