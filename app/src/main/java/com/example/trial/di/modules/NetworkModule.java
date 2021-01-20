package com.example.trial.di.modules;

import com.example.trial.remote.Userservice;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ViewModelModule.class)
public class NetworkModule {
    @Provides
    @Singleton
    static  Retrofit provideRetrofit()
    {
        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    static Userservice provideUserservice(Retrofit retrofit)
    {
        return retrofit.create(Userservice.class);
    }


}
