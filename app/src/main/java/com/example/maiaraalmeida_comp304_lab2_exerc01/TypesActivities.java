package com.example.maiaraalmeida_comp304_lab2_exerc01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import HouseTypes.AllTypes;
import HouseTypes.Apartment;
import HouseTypes.Condominium;
import HouseTypes.DetachedHome;
import HouseTypes.SemiDetachedHome;
import HouseTypes.TownHouse;
import Recycler.TypeRVAdaptor;

public class TypesActivities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types_activities);
        RecyclerView recyclerView = findViewById(R.id.homeTypeRecyclerView);
        TypeRVAdaptor adapter = new TypeRVAdaptor(getApplicationContext(),getHomeTypes());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //EventListeners

        adapter.setOnItemClickListener(new TypeRVAdaptor.OnItemListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getApplicationContext(),(String.valueOf(position)),Toast.LENGTH_SHORT).show();
                Intent intent;
                switch (position){
                    case 0: intent = new Intent(getApplicationContext(), Apartment.class);
                        break;
                    case 1: intent = new Intent(getApplicationContext(), DetachedHome.class);
                        break;
                    case 2: intent = new Intent(getApplicationContext(), SemiDetachedHome.class);
                        break;
                    case 3: intent = new Intent(getApplicationContext(), Condominium.class);
                        break;
                    case 4: intent = new Intent(getApplicationContext(), TownHouse.class);
                        break;
                    default: intent = new Intent(getApplicationContext(), AllTypes.class);
                        break;
                }
                startActivity(intent);
            }
        });
    }

    public ArrayList<String> getHomeTypes(){
        ArrayList<String> homeTypes = new ArrayList<String>();
        homeTypes.add("Apartment");
        homeTypes.add("Detached Home");
        homeTypes.add("Semi-detached Home");
        homeTypes.add("Condominium");
        homeTypes.add("Town House");
        homeTypes.add("All");
        return homeTypes;
    }
}