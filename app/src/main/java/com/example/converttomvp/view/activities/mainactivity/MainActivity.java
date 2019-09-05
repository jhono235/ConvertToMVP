package com.example.converttomvp.view.activities.mainactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.converttomvp.R;
import com.example.converttomvp.model.coffee.Coffee;
import com.example.converttomvp.model.coffee.CoffeeListEvent;
import com.example.converttomvp.view.adapters.CoffeeRvAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements  MainActivityContract {
@BindView(R.id.rvCoffeeList)
    RecyclerView rvCoffeeList;



MainActivityPresenter mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);



        mainActivityPresenter = new MainActivityPresenter(this);


    }

    @Override
    public void onAdapterReady(CoffeeRvAdapter adapter) {
        rvCoffeeList.setLayoutManager(new LinearLayoutManager(this));
        rvCoffeeList.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mainActivityPresenter.getCoffees();
    }


}
