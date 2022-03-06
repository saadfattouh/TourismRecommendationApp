package com.example.tourismrecommendationapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tourismrecommendationapp.R;
import com.example.tourismrecommendationapp.model.Tag;

import java.util.ArrayList;
import java.util.List;

public class DesiredPlacesAdapter extends RecyclerView.Adapter<DesiredPlacesAdapter.ViewHolder> {


    Context context;
    private List<Tag> list;

    private List<Tag> selectedTags;

    private int placesCounter = 0;

    // RecyclerView recyclerView;
    public DesiredPlacesAdapter(Context context, ArrayList<Tag> list) {
        this.context = context;
        this.selectedTags = new ArrayList<Tag>();
        this.list = list;
    }

    public List<Tag> getSelectedTags() {
        return selectedTags;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_interest, parent, false);

        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Tag tag = list.get(position);

        holder.name.setText(tag.getName());

        addPlaceTypes(holder.placeTypesRG, tag.getPlaceTypesList());
        holder.placeTypesRG.setVisibility(View.GONE);

        holder.placeTypesRG.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selected = group.findViewById(checkedId);
            int selectedIndex = tag.getPlaceTypesList().indexOf(selected.getText().toString());
            tag.setSelectedType(selectedIndex);
        });

        holder.check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        holder.placeTypesRG.setVisibility(View.VISIBLE);
                        if(placesCounter < 3){
                            placesCounter++;
                            selectedTags.add(tag);
                        }else {
                            Toast.makeText(context, "you can't choose more than 3 interests for better user experience", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        if(selectedTags.contains(tag))
                            selectedTags.remove(tag);
                        placesCounter--;
                        holder.placeTypesRG.setVisibility(View.GONE);
                    }

                }
            }
        );
    }

    private void addPlaceTypes(RadioGroup answersGroup, ArrayList<String> answers) {
        for (int i = 0; i < answers.size(); i++) {
            RadioButton rbn = new RadioButton(context);
            rbn.setId(View.generateViewId());
            rbn.setText(answers.get(i));
            rbn.setTextColor(context.getResources().getColor(R.color.black));
            rbn.setAlpha(0.8f);
            answersGroup.addView(rbn);
        }
    }

//    private void correctTheExam(){
//        strengths = new ArrayList<String>();
//        weaknesses = new ArrayList<String>();
//
//        marks = 0;
//        for (Tag tag: tags){
//            if(tag.getSelectedAnswer() == tag.getWriteAnswer()){
//                marks++;
//                strengths.add(tag.getLectureName());
//            }else {
//                weaknesses.add(tag.getLectureName());
//            }
//        }
//
//    }



    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView img;
        public TextView name;
        public CheckBox check;
        public RadioGroup placeTypesRG;

        public ViewHolder(View itemView) {
            super(itemView);
            this.img = itemView.findViewById(R.id.img);
            this.name = itemView.findViewById(R.id.name);
            this.check = itemView.findViewById(R.id.check);
            this.placeTypesRG = itemView.findViewById(R.id.place_types_group);
        }
    }


}