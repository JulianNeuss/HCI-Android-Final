package com.example.hciandroid.ui.favorites;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hciandroid.R;

import java.util.ArrayList;

public class FavoritesFragment extends Fragment {

    private RecyclerView recyclerFavorites;
    private ArrayList<String> favorites;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        favorites = new ArrayList<>();

        View view = inflater.inflate(R.layout.fragment_favs,container,false);
        recyclerFavorites = view.findViewById(R.id.recycler_view_id);
        recyclerFavorites.setLayoutManager(new LinearLayoutManager(getContext()));

        fillList();

        FavoritesAdapter favoritesAdapter = new FavoritesAdapter(favorites);
        recyclerFavorites.setAdapter(favoritesAdapter);

        favoritesAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "CLICKEADO",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


    //este tiene que pedirle los datos a la API
    private void fillList(){
        favorites.add("Cocina");
        favorites.add("Living");
        favorites.add("Dormitorio");
        favorites.add("Dormitorio2");
    }
}