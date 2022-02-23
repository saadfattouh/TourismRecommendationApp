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

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tourismrecommendationapp.R;
import com.example.tourismrecommendationapp.model.Tag;

import java.util.ArrayList;
import java.util.List;

public class DesiredPlacesAdapter extends RecyclerView.Adapter<DesiredPlacesAdapter.ViewHolder> {


    Context context;
    private List<Tag> list;
    private int marks;
    private ArrayList<String> strengths;
    private ArrayList<String> weaknesses;

    private int placesCounter = 0;

    // RecyclerView recyclerView;
    public DesiredPlacesAdapter(Context context, ArrayList<Tag> list) {
        this.context = context;
        this.list = list;
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

        holder.placeTypesRG.setVisibility(View.GONE);
        addPlaceTypes(holder.placeTypesRG, tag.getPlaceTypesList());

        holder.placeTypesRG.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selected = group.findViewById(checkedId);
            int selectedIndex = tag.getPlaceTypesList().indexOf(selected.getText().toString());
            tag.setSelectedType(selectedIndex);
        });

        holder.check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    holder.placeTypesRG.setVisibility(View.VISIBLE);
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

    public int getMarks() {
        return marks;
    }

    public ArrayList<String> getStrengths() {
        return strengths;
    }

    public ArrayList<String> getWeaknesses() {
        return weaknesses;
    }

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