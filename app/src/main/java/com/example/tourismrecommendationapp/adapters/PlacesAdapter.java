package com.example.tourismrecommendationapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tourismrecommendationapp.Constants;
import com.example.tourismrecommendationapp.PlaceDetailsActivity;
import com.example.tourismrecommendationapp.R;
import com.example.tourismrecommendationapp.model.Place;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.ViewHolder> {


    Context context;
    private List<Place> list;

    // RecyclerView recyclerView;
    public PlacesAdapter(Context context, ArrayList<Place> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_place_2, parent, false);

        return new ViewHolder(listItem);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Place place = list.get(position);

        holder.placeName.setText(place.getName());

        holder.tagName.setText(place.getTagName());

        if(place.getImage() != null){
            Glide.with(context)
                    .load(place.getImage())
                      .into(holder.img);
        }
        holder.itemView.setOnClickListener(v -> {
            Intent i = new Intent(context, PlaceDetailsActivity.class);
            i.putExtra(Constants.KEY_PLACE_NAME, place.getName());
            i.putExtra(Constants.KEY_PLACE_TAG, place.getTagName());
            i.putExtra(Constants.KEY_PLACE_RATING, place.getRating());
            i.putExtra(Constants.KEY_PLACE_DETAILS, place.getRegion());
            context.startActivity(i);
        });


    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public CircleImageView img;
        public TextView tagName;
        public TextView placeName;

        public ViewHolder(View itemView) {
            super(itemView);
            this.img = itemView.findViewById(R.id.img);
            this.placeName = itemView.findViewById(R.id.place_name);
            this.tagName = itemView.findViewById(R.id.tag_name);
        }
    }


}