package com.example.converttomvp.view.activities.detailactivity;

import com.example.converttomvp.model.coffee.Coffee;
import com.example.converttomvp.model.coffee.CoffeeEvent;

public interface DetailActivityContract {
    void onAdapterReady(Coffee coffee);
}
