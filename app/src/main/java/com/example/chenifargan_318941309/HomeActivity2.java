package com.example.chenifargan_318941309;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class HomeActivity2 extends AppCompatActivity {
private MaterialButton categoryBtn, LogOutBtn ,Promotionsbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        categoryBtn = findViewById(R.id.categorybtn);
        LogOutBtn= findViewById(R.id.Logoutbtn);
Promotionsbtn=findViewById(R.id.Promotionsbtn);
        categoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity2.this,CategoryActivity.class);
                startActivity(intent);

            }
        });
        LogOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity2.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

        Promotionsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity2.this,PromotionsActivity.class);
                startActivity(intent);


            }
        });

    }
}