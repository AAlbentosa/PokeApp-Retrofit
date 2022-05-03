package com.example.pokeapi.data.remote;

import com.example.pokeapi.data.model.Pokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JSONPlaceHolderApiService {

    @GET("pokemon/{id}")
    Call<Pokemon> getPokemon(@Path("id") String id);
}
