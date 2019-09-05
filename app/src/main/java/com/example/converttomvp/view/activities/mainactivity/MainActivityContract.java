package com.example.converttomvp.view.activities.mainactivity;

import com.example.converttomvp.view.adapters.CoffeeRvAdapter;

//for the presenter to communicate with the main activity
public interface MainActivityContract {
    void onAdapterReady(CoffeeRvAdapter adapter);
}
