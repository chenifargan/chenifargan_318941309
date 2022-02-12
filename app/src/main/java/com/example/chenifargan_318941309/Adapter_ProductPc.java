package com.example.chenifargan_318941309;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class Adapter_ProductPc extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Activity activity;
    private ArrayList<Product> productArrayList = new ArrayList<>();
    private ProductItemClickListener ProductItemClickListener;

    public Adapter_ProductPc(Activity activity, ArrayList<Product> products) {
        this.activity = activity;
        this.productArrayList = products;
    }

    public Adapter_ProductPc setMovieItemClickListener(ProductItemClickListener productItemClickListener) {
        this.ProductItemClickListener = productItemClickListener;
        return this;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_product_small, viewGroup, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ProductViewHolder movieViewHolder = (ProductViewHolder) holder;
        Product product = getItem(position);
        Log.d("pttt", "position= " + position);

        movieViewHolder.movie_LBL_title.setText(position + "\n" + product.getProduct());
   //     movieViewHolder.movie_LBL_actors.setText(movie.getActors());
        int h = product.getDuration() / 60;
        int m = product.getDuration() % 60;
        String hh = h < 10 ? "0" + h : "" + h;
        String mm = m < 10 ? "0" + m : "" + m;
        movieViewHolder.movie_LBL_duration.setText(hh + "h " + mm + "m");


        Glide
                .with(activity)
                .load(product.getImage())
                .into(movieViewHolder.movie_IMG_image);

        if (product.isFavorite()) {
            movieViewHolder.movie_IMG_favorite.setImageResource(R.drawable.ic_heart_filled);
        } else  {
            movieViewHolder.movie_IMG_favorite.setImageResource(R.drawable.ic_heart_empty);
        }

        float rating = product.getRating();
        rating /= 20;
        movieViewHolder.movie_RTNG_stars.setRating(rating);

    }
    private Product getItem(int position) {
        return productArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }
    public interface ProductItemClickListener {
        void productItemClicked(Product movie, int position);
        void favoriteClicked(Product movie, int position);
    }
    public class ProductViewHolder extends RecyclerView.ViewHolder {

        public AppCompatImageView movie_IMG_image;
        public AppCompatImageView movie_IMG_favorite;
        public MaterialTextView movie_LBL_title;
        public MaterialTextView movie_LBL_actors;
        public MaterialTextView movie_LBL_duration;
        public AppCompatRatingBar movie_RTNG_stars;

        public ProductViewHolder(final View itemView) {
            super(itemView);
            this.movie_IMG_image = itemView.findViewById(R.id.movie_IMG_image);
            this.movie_IMG_favorite = itemView.findViewById(R.id.movie_IMG_favorite);
            this.movie_LBL_title = itemView.findViewById(R.id.movie_LBL_title);
            //this.movie_LBL_actors = itemView.findViewById(R.id.movie_LBL_actors);
            this.movie_LBL_duration = itemView.findViewById(R.id.movie_LBL_duration);
            this.movie_RTNG_stars = itemView.findViewById(R.id.movie_RTNG_stars);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ProductItemClickListener.productItemClicked(getItem(getAdapterPosition()), getAdapterPosition());
                }
            });

            movie_IMG_favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ProductItemClickListener.favoriteClicked(getItem(getAdapterPosition()), getAdapterPosition());
                }
            });
        }
    }

}
