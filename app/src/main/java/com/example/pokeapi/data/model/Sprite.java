package com.example.pokeapi.data.model;

import com.google.gson.annotations.SerializedName;

public class Sprite {
    @SerializedName("front_default")
    private String url;

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return url;
    }
}
