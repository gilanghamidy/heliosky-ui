package com.heliosky.toolkit.ui;

import java.lang.reflect.Field;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.view.View;

/**
 * Functions for prepare widget reference to the class by automatically calling
 * findByViewId for each field which has WidgetReference annotation.
 * 
 * @author Gilang Mentari Hamidy
 * 
 */
public class WidgetReferenceFunctions {

	/**
	 * Method to prepare all widget reference defined in targetStore from the
	 * widget declared in targetView
	 * 
	 * @param targetStore
	 *            target object to store the reference
	 * @param targetView
	 *            target view to retrieve the widget
	 */
	public static final void prepareWidgetReference(Object targetStore,
			View targetView) {
		// Get targetStore class definition using reflection
		Class<?> clazz = targetStore.getClass();

		// For each declared fields within the class
		for (Field f : clazz.getDeclaredFields()) {
			// If annotation @WidgetReference is declared for the field, then
			if (f.isAnnotationPresent(WidgetReference.class)) {
				// Set the field accessible
				f.setAccessible(true);

				// Get the R.id value from annotation
				int id = ((WidgetReference) f
						.getAnnotation(WidgetReference.class)).value();
				try {
					// Find view by ID then store it to the declared field of
					// the target store object
					f.set(targetStore, targetView.findViewById(id));
				} catch (Exception e) {
					// Any exception, just throw it away
					throw new RuntimeException(e);
				}
			}
		}
	}

	/**
	 * Prepare the widget reference for specified activity
	 * 
	 * @param activity
	 *            Activity which will be prepared
	 */
	public static void prepareWidgetReference(Activity activity) {
		// Get root view
		View root = activity.findViewById(android.R.id.content);

		// Call prepareWidgetReference
		prepareWidgetReference(activity, root);
	}

	/**
	 * Prepare the widget reference for fragment
	 * 
	 * @param fragment
	 *            Fragment which will be prepared
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public static void prepareWidgetReference(Fragment fragment) {
		// Call prepareWidgetReference to the fragment
		prepareWidgetReference(fragment, fragment.getView());
	}

	/**
	 * Prepare the widget reference for Android Compatibility Framgent
	 * 
	 * @param fragment
	 *            Fragment which will be prepared
	 */
	public static void prepareWidgetReference(
			android.support.v4.app.Fragment fragment) {
		// Call prepareWidgetReference to the fragment
		prepareWidgetReference(fragment, fragment.getView());
	}
}
