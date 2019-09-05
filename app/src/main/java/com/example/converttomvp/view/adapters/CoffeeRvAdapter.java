package com.example.converttomvp.view.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.converttomvp.R;
import com.example.converttomvp.model.coffee.Coffee;
import com.example.converttomvp.view.activities.detailactivity.DetailActivity;

import java.util.ArrayList;
import java.util.List;

public class CoffeeRvAdapter extends RecyclerView.Adapter<CoffeeRvAdapter.ViewHolder> {
    List<Coffee> coffeeList;
    private Context context;
    private ItemClickListener itemClickListener;

    public interface ItemClickListener{
        void onItemClicked(Coffee coffee);
    }

    public CoffeeRvAdapter(List<Coffee> coffeeList) {
        this.coffeeList = coffeeList;


    }

    public Coffee coffee;

    @NonNull
    @Override
    public CoffeeRvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.coffee_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeRvAdapter.ViewHolder holder, int position) {
        coffee = coffeeList.get(position);
        holder.tvCoffeeName.setText(coffee.getName());
        holder.tvCoffeeDescription.setText(coffee.getDesc());

        Glide
                .with(holder.itemView)
                .load(coffee.getImageUrl())
                .into(holder.imgCoffeeImage);

    }

    @Override
    public int getItemCount() {
        return coffeeList.size();
    }

    public void setData(ArrayList<Coffee> coffees){
        this.coffeeList = coffees;
        notifyDataSetChanged();


    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCoffeeName;
        TextView tvCoffeeDescription;
        ImageView imgCoffeeImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCoffeeName = itemView.findViewById(R.id.tvCoffeeNameList);
            tvCoffeeDescription = itemView.findViewById(R.id.tvCoffeeDescriptionList);
            imgCoffeeImage = itemView.findViewById(R.id.ivCoffeePic);

            itemView.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //Toast.makeText(view.getContext(), coffeeList.get(getAdapterPosition()).getId(), Toast.LENGTH_LONG).show();
                           Intent intent = new Intent(view.getContext(), DetailActivity.class);
                           intent.putExtra("passedId", coffeeList.get(getAdapterPosition()).getId());
                           view.getContext().startActivity(intent);



                        }
                    });
        }
    }
}
