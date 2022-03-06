package com.example.tourismrecommendationapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class PlaceDetailsActivity extends AppCompatActivity {

    RatingBar ratingBar;
    Button mBookBtn , mRateBtn;
    TextView mPlaceNameTv, mTagTV, mDetailsTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);
        ratingBar = findViewById(R.id.rating);
        mBookBtn = findViewById(R.id.book_btn);
        mRateBtn = findViewById(R.id.rate_btn);
        mPlaceNameTv = findViewById(R.id.name);
        mTagTV = findViewById(R.id.tag);
        mDetailsTV = findViewById(R.id.details);

        Intent i = new Intent();
        String name = i.getStringExtra(Constants.KEY_PLACE_NAME);
        String tag = i.getStringExtra(Constants.KEY_PLACE_TAG);
        String details = i.getStringExtra(Constants.KEY_PLACE_DETAILS);
        double ratingFrom = i.getDoubleExtra(Constants.KEY_PLACE_RATING, 0.0);

        mPlaceNameTv.setText(name);
        mTagTV.setText(tag);
        ratingBar.setRating((float)ratingFrom);
        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            String rat = "Rating is :" + ratingBar.getRating();
            Toast.makeText(this, rat, Toast.LENGTH_LONG).show();


        });

        mRateBtn.setOnClickListener(v->{

                LayoutInflater factory = LayoutInflater.from(this);
                final View view = factory.inflate(R.layout.dialog_rating, null);
                final AlertDialog ratingDialog = new AlertDialog.Builder(this).create();
                ratingDialog.setView(view);
                ratingDialog.setCanceledOnTouchOutside(true);

                RatingBar dialogRatingBar = findViewById(R.id.dialog_rating);
                dialogRatingBar.setOnRatingBarChangeListener((ratingBar1, rating1, fromUser1) -> {
                    String rat1 = "Rating is :" + ratingBar1.getRating();
                    Toast.makeText(this, rat1, Toast.LENGTH_LONG).show();
                    ratingDialog.dismiss();

                ratingDialog.show();
            });
        });

    }
}