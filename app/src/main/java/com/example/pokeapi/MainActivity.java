package com.example.pokeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pokeapi.data.model.Abilities;
import com.example.pokeapi.data.model.Ability;
import com.example.pokeapi.data.model.Pokemon;
import com.example.pokeapi.data.remote.JSONPlaceHolderApiService;
import com.squareup.picasso.Picasso;

import java.net.URI;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ImageView pokemonPicture;
    TextView nameView;
    TextView heightView;
    TextView weightView;
    TextView abilitysView;
    EditText pokemonID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pokemonPicture=findViewById(R.id.pokemonPicture);
        nameView=findViewById(R.id.NameView);
        heightView=findViewById(R.id.HeightView);
        weightView=findViewById(R.id.WeightView);
        abilitysView=findViewById(R.id.AbilitysView);
        pokemonID=(EditText)findViewById(R.id.pokemonID);
    }

    public void getPokemon(View _){
        String id=pokemonID.getText().toString().trim();
        if(!id.equals("")) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://pokeapi.co/api/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            JSONPlaceHolderApiService apiService = retrofit.create(JSONPlaceHolderApiService.class);
            Call<Pokemon> pokemon = apiService.getPokemon(id);
            pokemon.enqueue(new Callback<Pokemon>() {
                @Override
                public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                    if (!response.isSuccessful()) {
                        String error = "Ha ocurrido un problema al intentar conectar a la API";
                        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
                        resetfields();
                    } else {
                        Pokemon pokemon = response.body();

                        nameView.setText(pokemon.getName());
                        heightView.setText("" + pokemon.getHeight());
                        weightView.setText("" + pokemon.getWeight());
                        String abilities = "";
                        for (Abilities a : pokemon.getAbilities()) {
                            abilities += a + "\n";
                        }
                        abilitysView.setText(abilities);
                        Picasso.get().load(pokemon.getSprites().toString()).into(pokemonPicture);
                    }
                }

                @Override
                public void onFailure(Call<Pokemon> call, Throwable t) {
                    String error = "Ha ocurrido un problema al intentar conectar a la API";
                    Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
                    resetfields();
                }
            });
        }
    }

    private void resetfields() {
        pokemonPicture.setImageResource(0);
        nameView.setText("");
        heightView.setText("");;
        weightView.setText("");;
        abilitysView.setText("");;
    }
}