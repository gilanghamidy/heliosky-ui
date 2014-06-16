heliosky-toolkit.ui
===========

## What's this?
Tired of writing and seeing findByViewId every single time you want to retrieve reference to your widget from Android layout file? This is a simple library to help you set up widget reference for your Activity, Fragment, or any View.

## The Old Way
```java
public class MyActivity extends Activity {
  TextView mTextViewName;
  EditText mEditTextYourMomma;
  
  protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Get root view
		View root = activity.findViewById(android.R.id.content);
		
		this.mTextViewName = root.findViewById(R.id.MyActivity_TextView_Name);
		this.mEditExtYourMomma = root.findViewById(R.id.MyActivity_TextView_YourMomma);
		
		this.mTextViewName.setText("Your momma is so big!");
  }
}
```

## The Helios Way
```java
import com.heliosky.toolkit.ui.WidgetReferenceFunctions;

public class MyActivity extends Activity {
  @WidgetReference(R.id.MyActivity_TextView_Name)
  TextView mTextViewName;
  
  @WidgetReference(R.id.MyActivity_EditText_YourMomma)
  EditText mEditTextYourMomma;
  
  protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		WidgetReferenceFunctions.prepareWidgetReference(this);
		
		this.mTextViewName.setText("Your momma is so big!");
	}
}
```

## How The Magic Works?
Reflection.

## License
The library is Copyright (c) 2014 Gilang Mentari Hamidy @ Heliosky.com, and distributed under the MIT License.
