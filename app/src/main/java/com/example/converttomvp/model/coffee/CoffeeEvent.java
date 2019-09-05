package com.example.converttomvp.model.coffee;

import java.io.Serializable;

public class CoffeeEvent implements Serializable {

    Coffee coffee;

    public CoffeeEvent(Coffee coffee) {
        this.coffee = coffee;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }
}
