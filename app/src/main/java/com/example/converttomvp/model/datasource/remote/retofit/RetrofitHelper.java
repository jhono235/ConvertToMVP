package com.example.converttomvp.model.datasource.remote.retofit;

import com.example.converttomvp.model.datasource.remote.retofit.apiservices.ObservableCoffeeService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.converttomvp.model.datasource.remote.retofit.UrlConstants.BASE_URL;

public class RetrofitHelper {



    private Retrofit getRetrofitInstance(){
        return new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public  ObservableCoffeeService getObsService(){
        return getRetrofitInstance()
                .create(ObservableCoffeeService.class);

    }


}
