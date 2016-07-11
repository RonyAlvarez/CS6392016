package com.ronyalvarez.cs639firebase;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by ronyalvarez on 7/10/16.
 */
public class Config extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
