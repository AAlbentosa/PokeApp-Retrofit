package com.example.pokeapi.data.model;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    private String name;
    private int height;
    private int weight;
    private List<Abilities> abilities;
    private Sprite sprites;

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public List<Abilities> getAbilities() {
        return abilities;
    }

    public Sprite getSprites() {
        return sprites;
    }
}
