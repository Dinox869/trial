package com.example.trial.di.components;


import com.example.trial.MainActivity;
import com.example.trial.di.modules.NetworkModule;
import com.example.trial.di.modules.ContextModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = NetworkModule.class
        //, ContextModule.class
        )
public interface AppComponent {

    void inject(MainActivity mainActivity);
}
