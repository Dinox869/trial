package com.example.trial.remote;

import com.example.trial.model.Usermodel;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface Userservice {


    @GET("/users/2")
    Single<Usermodel> getUsermodel();


}
