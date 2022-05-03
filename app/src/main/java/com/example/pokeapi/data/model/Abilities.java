package com.example.pokeapi.data.model;

public class Abilities {
    private Ability ability;

    public Ability getAbility() {
        return ability;
    }

    @Override
    public String toString() {
        return ability.toString();
    }
}
