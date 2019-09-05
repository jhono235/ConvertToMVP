package com.example.converttomvp.view.activities.detailactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.converttomvp.R;
import com.example.converttomvp.model.coffee.Coffee;
import com.example.converttomvp.model.coffee.CoffeeEvent;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements DetailActivityContract {
    DetailActivityPresenter detailActivityPresenter;

    //binding views
    @BindView(R.id.tvNameDetail)
    TextView tvNameDetail;

    @BindView(R.id.tvDetailDetail)
    TextView tvDetailDetail;

    @BindView(R.id.imgDetailsPic)
    ImageView imgDetailsPic;

    String passedId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        detailActivityPresenter = new DetailActivityPresenter(this);

        Intent intent = getIntent();
        passedId = intent.getStringExtra("passedId");



    }





    @Override
    protected void onStart() {
        super.onStart();
        detailActivityPresenter.getCoffee(passedId);
    }


    @Override
    public void onAdapterReady(Coffee coffee) {
        tvNameDetail.setText(coffee.getName());
        tvDetailDetail.setText(coffee.getDesc());

        Glide
                .with(this)
                .load(coffee.getImageUrl())
                .into(imgDetailsPic);
    }
}
