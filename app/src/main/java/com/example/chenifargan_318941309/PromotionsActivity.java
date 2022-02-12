package com.example.chenifargan_318941309;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatRatingBar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textview.MaterialTextView;

public class PromotionsActivity extends AppCompatActivity {

    private AppCompatImageView movie1_IMG_favorite;
    private MaterialTextView movie1_LBL_title;
    private AppCompatImageView movie2_IMG_favorite;
    private MaterialTextView movie2_LBL_title;
    private AppCompatImageView movie3_IMG_favorite;
    private MaterialTextView movie3_LBL_title;
    private AppCompatImageView movie4_IMG_favorite;
    private MaterialTextView movie4_LBL_title;
    private AppCompatImageView movie5_IMG_favorite;
    private MaterialTextView movie5_LBL_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotions);

        movie1_IMG_favorite =findViewById(R.id.movie1_IMG_favorite);
        movie1_LBL_title =findViewById(R.id.movie1_LBL_title);
        movie2_IMG_favorite =findViewById(R.id.movie2_IMG_favorite);
        movie2_LBL_title =findViewById(R.id.movie2_LBL_title);
        movie3_IMG_favorite =findViewById(R.id.movie3_IMG_favorite);
        movie3_LBL_title =findViewById(R.id.movie3_LBL_title);
        movie4_IMG_favorite =findViewById(R.id.movie4_IMG_favorite);
        movie4_LBL_title =findViewById(R.id.movie4_LBL_title);
        movie5_IMG_favorite =findViewById(R.id.movie5_IMG_favorite);
        movie5_LBL_title =findViewById(R.id.movie5_LBL_title);

        movie1_IMG_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movie1_IMG_favorite.setImageResource(R.drawable.ic_heart_filled);
                Toast.makeText(PromotionsActivity.this,"The benefit was received",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(PromotionsActivity.this,HomeActivity2.class);
                startActivity(intent);
                finish();

            }
        });


        movie2_IMG_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movie1_IMG_favorite.setImageResource(R.drawable.ic_heart_filled);
                Toast.makeText(PromotionsActivity.this,"The benefit was received",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(PromotionsActivity.this,HomeActivity2.class);
                startActivity(intent);
                finish();


            }
        });
        movie3_IMG_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movie1_IMG_favorite.setImageResource(R.drawable.ic_heart_filled);
                Toast.makeText(PromotionsActivity.this,"The benefit was received",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(PromotionsActivity.this,HomeActivity2.class);
                startActivity(intent);
                finish();


            }
        });
        movie4_IMG_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movie1_IMG_favorite.setImageResource(R.drawable.ic_heart_filled);
                Toast.makeText(PromotionsActivity.this,"The benefit was received",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(PromotionsActivity.this,HomeActivity2.class);
                startActivity(intent);
                finish();


            }
        });
        movie5_IMG_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movie1_IMG_favorite.setImageResource(R.drawable.ic_heart_filled);
                Toast.makeText(PromotionsActivity.this,"The benefit was received",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(PromotionsActivity.this,HomeActivity2.class);
                startActivity(intent);
                finish();

            }
        });

    }
}