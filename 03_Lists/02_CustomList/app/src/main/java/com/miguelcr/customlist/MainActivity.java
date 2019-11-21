package com.miguelcr.customlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    List<Restaurant> restaurantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Get the reference for the ListView component
        lista = findViewById(R.id.listViewRestaurants);

        // 2. set demo data into the List of restaurants
        restaurantList = new ArrayList<>();
        restaurantList.add(new Restaurant("Goiko Grill", "Avda. Republica Argentina, Sevilla", "https://i1.wp.com/www.diegocoquillat.com/wp-content/uploads/2018/04/El-top-5-de-hamburguesas-de-Goikogrill-que-arrasan-en-Instagram.jpg", 5));
        restaurantList.add(new Restaurant("Happy Doner", "Main Street, Zagan", "https://okdiario.com/img/2019/06/12/receta-de-kebab-de-cerdo-casero-655x368.jpg", 5));

        // 3. Custom Adapter
        RestaurantAdapter adapter = new RestaurantAdapter(
                this,
                R.layout.restaurant_item,
                restaurantList
        );

        // 4. Connect ListView and the Adapter
        lista.setAdapter(adapter);

    }


}
