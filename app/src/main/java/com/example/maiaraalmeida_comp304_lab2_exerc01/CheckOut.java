package com.example.maiaraalmeida_comp304_lab2_exerc01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import Recycler.HomeDetail;
import payment.Payment;

public class CheckOut extends AppCompatActivity {

    ArrayList<GetHouse> homeList = getVisitedHomes();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        RecyclerView recyclerView = findViewById(R.id.RecyclerCheckout);
        HomeDetail adapter = new HomeDetail(getApplicationContext(), homeList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setOnItemClickListener(new HomeDetail.OnItemListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent;
                intent = new Intent(getApplicationContext(), Payment.class);
                intent.putExtra("HOME_ID", String.valueOf(GetHouse.getHomeList.get(position)));
                startActivity(intent);
            }
        });
    }

    public ArrayList<GetHouse> getVisitedHomes(){
        ArrayList<GetHouse> list = new ArrayList<>();
        for (GetHouse house : GetHouse.getHomeList){
            if(house.isVisitInPerson() || house.isVisitVirtual()){
                list.add(house);
            }
        }
        return list;
    }
}