package com.example.chenifargan_318941309;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class UserChoosePCProductActivity extends AppCompatActivity {
    private RecyclerView main_LST_movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_choose_product);

        main_LST_movies = findViewById(R.id.main_LST_movies);


        ArrayList<Product> Product = DataManagerPc.generateMovies();

        Adapter_ProductPc adapter_movie = new Adapter_ProductPc(this, Product);


        // Grid
        main_LST_movies.setLayoutManager(new GridLayoutManager(this, 2));

        // Vertically
        //main_LST_movies.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        main_LST_movies.setHasFixedSize(true);
        main_LST_movies.setItemAnimator(new DefaultItemAnimator());
        main_LST_movies.setAdapter(adapter_movie);

        adapter_movie.setMovieItemClickListener(new Adapter_ProductPc.ProductItemClickListener() {

            @Override
            public void productItemClicked(Product product, int position) {
                Toast.makeText(UserChoosePCProductActivity.this,product.getProduct(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void favoriteClicked(Product product, int position) {
                product.setFavorite(!product.isFavorite());
                Toast.makeText(UserChoosePCProductActivity.this, product.isFavorite() + "\n" + product.getProduct(), Toast.LENGTH_SHORT).show();
                main_LST_movies.getAdapter().notifyItemChanged(position);
            }
        });



    }
}