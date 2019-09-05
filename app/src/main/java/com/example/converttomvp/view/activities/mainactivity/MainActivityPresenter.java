package com.example.converttomvp.view.activities.mainactivity;

import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.example.converttomvp.model.coffee.Coffee;
import com.example.converttomvp.model.coffee.CoffeeListEvent;
import com.example.converttomvp.model.datasource.remote.retofit.RetrofitHelper;
import com.example.converttomvp.view.adapters.CoffeeRvAdapter;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivityPresenter {
    MainActivityContract contract;


    public MainActivityPresenter(MainActivityContract contract) {
        this.contract = contract;
    }

    public void getCoffees() {
        RetrofitHelper retrofitHelper = new RetrofitHelper();
        retrofitHelper.getObsService()
                .getCoffees()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Coffee>>() {
                    List<Coffee> coffees;
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Coffee> coffees) {
                        this.coffees = coffees;

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG_PRESENTER_MAIN", "ERROR IN API CALL -->", e);

                    }

                    @Override
                    public void onComplete() {
                        setupAdapter(new CoffeeListEvent(coffees));

                    }
                });


    }

    public void setupAdapter(CoffeeListEvent coffees){
        CoffeeRvAdapter coffeeRvAdapter = new CoffeeRvAdapter(coffees.getCoffees());
        contract.onAdapterReady(coffeeRvAdapter);
    }


}
