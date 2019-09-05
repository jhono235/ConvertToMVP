package com.example.converttomvp.model.datasource.remote.retofit.apiservices;

import com.example.converttomvp.model.coffee.Coffee;
import com.example.converttomvp.model.coffee.CoffeeListEvent;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static com.example.converttomvp.model.datasource.remote.retofit.UrlConstants.PATH_COFFEES;
import static com.example.converttomvp.model.datasource.remote.retofit.UrlConstants.QUERY_ALL;

public interface ObservableCoffeeService {

    @GET(QUERY_ALL)
    Observable<List<Coffee>> getCoffees();

    @GET(PATH_COFFEES)
    Observable<Coffee> getCoffee(@Path("coffeeId") String coffeeId);

}
