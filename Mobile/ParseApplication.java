package com.example.demo;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;


public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

	// Add your initialization code here
	Parse.initialize(this, "W10AcPJEV80Pycuy3ZXtRfLi06VNzvy680rtPm9N", "yIkBHQWdWdZljTpJENeDdMZkfCtsvrCTGwgb5oYW");
	
  
        // ...
  }		
}