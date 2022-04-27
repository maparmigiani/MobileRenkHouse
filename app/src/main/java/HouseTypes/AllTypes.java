package HouseTypes;

import android.content.Intent;
import android.os.Bundle;

import com.example.maiaraalmeida_comp304_lab2_exerc01.CheckOut;
import com.example.maiaraalmeida_comp304_lab2_exerc01.GetHouse;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import Recycler.HomeDetail;

import com.example.maiaraalmeida_comp304_lab2_exerc01.R;

import java.util.ArrayList;

public class AllTypes extends AppCompatActivity {

    ArrayList<GetHouse> homeList = GetHouse.getHomeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_types);
        RecyclerView recyclerView = findViewById(R.id.AllTypes);
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
                intent = new Intent(getApplicationContext(), AllTypes.class);
                break;
        }

        startActivity(intent);


        return false;
    }
}