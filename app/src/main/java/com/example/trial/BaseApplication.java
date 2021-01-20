package com.example.trial;

import android.app.Application;

import com.example.trial.di.components.AppComponent;
import com.example.trial.di.components.DaggerAppComponent;

public class BaseApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
