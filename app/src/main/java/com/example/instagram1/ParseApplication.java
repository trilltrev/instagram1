package com.example.instagram1;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //register parse models
        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("4F8yOFfqIu8JDCeNLYi5MUWqEBghdgdzGa7E0Ptu")
                .clientKey("rwQfzqIDM0R6QNxWuOz4HyDcttdkiCOUvRBEvtk9")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
