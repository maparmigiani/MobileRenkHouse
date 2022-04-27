package com.example.maiaraalmeida_comp304_lab2_exerc01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnEnter;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEnter = findViewById(R.id.btnEnter);
        imgView = findViewById(R.id.imageView);
        fillHomeList();

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"click",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),TypesActivities.class);
                startActivity(intent);

            }
        });
    }
    public void fillHomeList(){
        GetHouse.getHomeList.add(new GetHouse("detached",1000,String.valueOf(R.drawable.detachedhome1),"Egliton"));
        GetHouse.getHomeList.add(new GetHouse("detached",1000,String.valueOf(R.drawable.detachedhome2),"Etobicoke"));
        GetHouse.getHomeList.add(new GetHouse("apartment",2000,String.valueOf(R.drawable.apartment1),"Egliton"));
        GetHouse.getHomeList.add(new GetHouse("apartment",2000,String.valueOf(R.drawable.apartment2),"Etobicoke"));
        GetHouse.getHomeList.add(new GetHouse("semi",3000,String.valueOf(R.drawable.semidetachedhome1),"Egliton"));
        GetHouse.getHomeList.add(new GetHouse("semi",3000,String.valueOf(R.drawable.semidetachedhome2),"Etobicoke"));
        GetHouse.getHomeList.add(new GetHouse("townhouse",4000,String.valueOf(R.drawable.townhouse1),"Egliton"));
        GetHouse.getHomeList.add(new GetHouse("townhouse",4000,String.valueOf(R.drawable.townhouse2),"Etobicoke"));
        GetHouse.getHomeList.add(new GetHouse("condominium",2000,String.valueOf(R.drawable.condominium1),"Egliton"));
        GetHouse.getHomeList.add(new GetHouse("condominium",2000,String.valueOf(R.drawable.condominium2),"Etobicoke"));

    }
}