package com.example.trial.repository;

import com.example.trial.model.Usermodel;
import com.example.trial.remote.Userservice;

import javax.inject.Inject;

import io.reactivex.Single;

public class Userrepository {
     private Userservice userservice;

     @Inject
    public Userrepository(Userservice userservice) {
        this.userservice = userservice;
    }

    public Single<Usermodel> modelSingle()
    {
        return userservice.getUsermodel();
    }
}
