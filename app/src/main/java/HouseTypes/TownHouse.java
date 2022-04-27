package HouseTypes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.maiaraalmeida_comp304_lab2_exerc01.CheckOut;
import com.example.maiaraalmeida_comp304_lab2_exerc01.GetHouse;
import com.example.maiaraalmeida_comp304_lab2_exerc01.R;

import java.util.ArrayList;

import Recycler.HomeDetail;

public class TownHouse extends AppCompatActivity {

    ArrayList<GetHouse> homeList = getTownHouses();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_town_house);
        RecyclerView recyclerView = findViewById(R.id.RecyclerTownHouse);
        HomeDetail adapter = new HomeDetail(getApplicationContext(),homeList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menudisplay, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected Item: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        Intent intent;
        switch (item.getItemId()) {
            case R.id.menuItemAll:
                intent = new Intent(getApplicationContext(), AllTypes.class);
                break;
            case R.id.menuItemApartment:
                intent = new Intent(getApplicationContext(), Apartment.class);
                break;
            case R.id.menuItemCondominium:
                intent = new Intent(getApplicationContext(), Condominium.class);
                break;
            case R.id.menuItemDetachedHome:
                intent = new Intent(getApplicationContext(), DetachedHome.class);
                break;
            case R.id.menuItemSemiDetached:
                intent = new Intent(getApplicationContext(), SemiDetachedHome.class);
                break;
            case R.id.menuItemTownHouse:
                intent = new Intent(getApplicationContext(), TownHouse.class);
                break;
            case R.id.menuCheckOut:
                intent = new Intent(getApplicationContext(), CheckOut.class);
                break;
            default:
                intent = new Intent(getApplicationContext(), TownHouse.class);
                break;
        }
        startActivity(intent);
        return false;
    }

    public ArrayList<GetHouse> getTownHouses(){
        ArrayList<GetHouse> homes = new ArrayList<>();
        for(GetHouse home : GetHouse.getHomeList){
            if(home.getHomeType().equals("townhouse")) homes.add(home);
        }
        return homes;
    }
}