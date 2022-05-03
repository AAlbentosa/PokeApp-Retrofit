package com.example.pokeapi.data.model;

import com.google.gson.annotations.SerializedName;

public class Ability {
    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
