package com.example.trial.viewmodel;

import com.example.trial.model.Usermodel;
import com.example.trial.repository.Userrepository;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class UserViewModel  extends ViewModel {

    private Userrepository userrepository;
    private CompositeDisposable disposable = new CompositeDisposable();
    private  MutableLiveData<Usermodel> modelmutableLiveData = new MutableLiveData<>();

    @Inject
    public UserViewModel (Userrepository userrepository)
    {
        this.userrepository = userrepository;
    }

    public  MutableLiveData<Usermodel> getModelMutableLiveData()
    {
        loadData();
        return modelmutableLiveData;
    }

    private void loadData()
    {
        disposable.add(userrepository.modelSingle()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<Usermodel>() {
                    @Override
                    public void onSuccess(Usermodel usermodel) {
                        getModelMutableLiveData().setValue(usermodel);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                }));
    }

}
