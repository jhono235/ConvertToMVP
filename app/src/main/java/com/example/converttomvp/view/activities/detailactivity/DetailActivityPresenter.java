package com.example.converttomvp.view.activities.detailactivity;

import android.content.Intent;
import android.util.Log;

import com.example.converttomvp.model.coffee.Coffee;
import com.example.converttomvp.model.coffee.CoffeeEvent;
import com.example.converttomvp.model.coffee.CoffeeListEvent;
import com.example.converttomvp.model.datasource.remote.retofit.RetrofitHelper;
import com.example.converttomvp.view.adapters.CoffeeRvAdapter;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;



public class DetailActivityPresenter {
    DetailActivityContract contract;



    public DetailActivityPresenter(DetailActivityContract contract){
        this.contract = contract;


    }

    public void getCoffee(String coffeeId){
        RetrofitHelper retrofitHelper = new RetrofitHelper();

            retrofitHelper.getObsService()
                    .getCoffee(coffeeId)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Observer<Coffee>() {
                        private Coffee coffee;
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(Coffee coffee) {
                            this.coffee = coffee;

                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d("TAG_PRESENTER_DETAIL", "ERROR IN API CALL -->", e);

                        }

                        @Override
                        public void onComplete() {
                            contract.onAdapterReady(coffee);


                        }
                    });
        }





    }




