package com.example.trial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import com.example.trial.databinding.ActivityMainBinding;
import com.example.trial.model.Usermodel;
import com.example.trial.viewmodel.UserViewModel;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private UserViewModel userViewModel;
    private static final String  TAG = "mainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        ((BaseApplication)  getApplication()).getAppComponent().inject(this);

        userViewModel = ViewModelProviders.of(this,viewModelFactory).get(UserViewModel.class);
        userViewModel.getModelMutableLiveData().observe(this, new Observer<Usermodel>() {
            @Override
            public void onChanged(Usermodel usermodel) {
                activityMainBinding.setUser(usermodel);
                Log.d(TAG,"onchange"+usermodel.getPhone());
            }
        });

    }
}