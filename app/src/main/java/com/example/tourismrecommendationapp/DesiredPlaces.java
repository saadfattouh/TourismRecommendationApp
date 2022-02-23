package com.example.tourismrecommendationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.tourismrecommendationapp.adapters.DesiredPlacesAdapter;
import com.example.tourismrecommendationapp.model.Tag;

import java.util.ArrayList;

public class DesiredPlaces extends AppCompatActivity {
    Context ctx;

    ArrayList<Tag> tags;
    RecyclerView mList;
    DesiredPlacesAdapter mAdapter;

    int desiredPlacesCounter = 0;
    ArrayList<Tag> desiredTags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_interests);

        ArrayList<String> types = new ArrayList<String>(){{
            add("italian restaurant");
            add("arabic restaurant");
            add("italian restaurant");

        }};
        mList = findViewById(R.id.rv);
        tags = new ArrayList<Tag>(){{

            add(new Tag(1, "mosques", new ArrayList<String>()));
        }};
        mAdapter = new DesiredPlacesAdapter(this, tags);
        mList.setAdapter(mAdapter);
    }

}