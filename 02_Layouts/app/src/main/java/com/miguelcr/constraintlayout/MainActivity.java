package com.miguelcr.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    ImageView ivPhoto;
    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Loading the User Interface (layout)
        setContentView(R.layout.activity_main);

        // We get the reference to the view component
        ivPhoto = findViewById(R.id.imageViewPhoto);

        // Load an image from internet into the ivPhoto
        Glide.with(this)
                .load("http://www.confero.pl/content/img/mdwc/19346.jpg")
                .centerCrop()
                .into(ivPhoto);

        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0);
        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(colorMatrix);
        ivPhoto.setColorFilter(filter);

    }
}
