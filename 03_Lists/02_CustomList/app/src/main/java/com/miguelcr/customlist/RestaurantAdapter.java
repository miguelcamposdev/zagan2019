package com.miguelcr.customlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

public class RestaurantAdapter extends ArrayAdapter<Restaurant> {
    Context ctx;
    int layoutTemplate;
    List<Restaurant> restaurantList;


    // To generate this Adapter
    public RestaurantAdapter(@NonNull Context context, int resource, @NonNull List<Restaurant> objects) {
        super(context, resource, objects);

        this.ctx = context;
        this.layoutTemplate = resource;
        this.restaurantList = objects;

    }

    // To draw each element with the design we have in the layout restaurant_item.xml
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutTemplate, parent, false);

        // 1. Get the current Restaurant
        Restaurant current = restaurantList.get(position);

        // 2. Get the restaurant information
        String name = current.getName();
        String address = current.getAddress();
        String photo = current.getPhotoUrl();
        int rate = current.getRate();

        // 3. Get the view components references
        ImageView ivPhoto = v.findViewById(R.id.imageViewPhoto);
        TextView tvName = v.findViewById(R.id.textViewName);
        TextView tvAddress = v.findViewById(R.id.textViewAddress);
        RatingBar ratingBar = v.findViewById(R.id.ratingBarRate);

        // 4. Set the restaurant information into the view components
        tvName.setText(name);
        tvAddress.setText(address);
        ratingBar.setRating((float) rate);
        Glide.with(ctx)
                .load(photo)
                .centerCrop()
                .into(ivPhoto);

        return v;
    }
}
