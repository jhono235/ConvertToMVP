package com.example.converttomvp.model.coffee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class CoffeeListEvent implements Serializable {

    @SerializedName("coffees")
    @Expose
    private List<Coffee> coffees = null;

    public CoffeeListEvent(List<Coffee> coffee){
        this.coffees = coffee;
    }

    public List<Coffee> getCoffees() {
        return coffees;
    }
}
