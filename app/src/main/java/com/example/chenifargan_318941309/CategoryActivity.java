package com.example.chenifargan_318941309;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CategoryActivity extends AppCompatActivity {
    private ImageView tShirts, sportsTShirts,femaleDresses,sweathers;
    private ImageView glasses, hatsCaps,walletsBagsPurses,shoes;
    private ImageView headPhonesHandFree, Laptops,watches,mobilePhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        initViews();

        tShirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CategoryActivity.this, UserChoosePCProductActivity.class);
                intent.putExtra("category","tShirts");
                startActivity(intent);
            }
        });

        sportsTShirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CategoryActivity.this, UserChoosePCProductActivity.class);
                intent.putExtra("category","Sports tShirts");
                startActivity(intent);
            }
        });
        femaleDresses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CategoryActivity.this, UserChoosePCProductActivity.class);
                intent.putExtra("category","Female Dresses");
                startActivity(intent);
            }
        });
        sweathers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CategoryActivity.this, UserChoosePCProductActivity.class);
                intent.putExtra("category","Sweathers");
                startActivity(intent);
            }
        });
        glasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CategoryActivity.this, UserChoosePCProductActivity.class);
                intent.putExtra("category","Glasses");
                startActivity(intent);
            }
        });
        hatsCaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CategoryActivity.this, UserChoosePCProductActivity.class);
                intent.putExtra("category","Hats Caps");
                startActivity(intent);
            }
        });
        walletsBagsPurses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CategoryActivity.this, UserChoosePCProductActivity.class);
                intent.putExtra("category","Wallets Bags Purses");
                startActivity(intent);
            }
        });
        shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CategoryActivity.this, UserChoosePCProductActivity.class);
                intent.putExtra("category","Shoes");
                startActivity(intent);
            }
        });
        headPhonesHandFree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CategoryActivity.this, UserChoosePCProductActivity.class);
                intent.putExtra("category","HeadPhones HandFree");
                startActivity(intent);
            }
        });
        Laptops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CategoryActivity.this, UserChoosePCProductActivity.class);
                intent.putExtra("category","Laptops");
                startActivity(intent);
            }
        });
        watches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CategoryActivity.this, UserChoosePCProductActivity.class);
                intent.putExtra("category","Watches");
                startActivity(intent);
            }
        });
        mobilePhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CategoryActivity.this, UserChoosePCProductActivity.class);
                intent.putExtra("category","Mobile Phone");
                startActivity(intent);
            }
        });


    }
    private void initViews() {
        tShirts =findViewById(R.id.t_shirts);
        sportsTShirts =findViewById(R.id.sport_t_shirts);
        femaleDresses =findViewById(R.id.female_dresses);
        sweathers =findViewById(R.id.sweathers);
        glasses =findViewById(R.id.glasses);
        hatsCaps =findViewById(R.id.hats_caps);
        walletsBagsPurses =findViewById(R.id.purses_bags_wallets);
        shoes =findViewById(R.id.shoes);
        headPhonesHandFree =findViewById(R.id.headphones_handfree);
        Laptops =findViewById(R.id.laptop_pc);
        watches =findViewById(R.id.watch);
        mobilePhone =findViewById(R.id.mobilephones);

    }
}