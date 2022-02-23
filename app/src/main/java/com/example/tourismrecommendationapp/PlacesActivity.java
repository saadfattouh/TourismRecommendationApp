package com.example.tourismrecommendationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.tourismrecommendationapp.adapters.DesiredPlacesAdapter;
import com.example.tourismrecommendationapp.fragments.PlacesFragment;
import com.example.tourismrecommendationapp.model.Tag;
import com.example.tourismrecommendationapp.pagers.CategoriesPlacesPager;
import com.kekstudio.dachshundtablayout.DachshundTabLayout;

import java.util.ArrayList;
import java.util.List;

public class PlacesActivity extends AppCompatActivity {

    //initializing variables
    DachshundTabLayout mCategoriesTabLayout;
    CategoriesPlacesPager mTabsAdapter;
    ViewPager mTagsPager;
    ImageView backBtn;

    ArrayList<Tag> tags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        //binding
        mCategoriesTabLayout = findViewById(R.id.categories_tab_layout);
        mTagsPager = findViewById(R.id.tags_pager);
        backBtn = findViewById(R.id.back_btn);

        getTags();
    }

    private void getTags() {
        ArrayList<String> types = new ArrayList<String>()
        {{
            add("italian restaurant");
            add("arabic restaurant");
            add("italian restaurant");
        }};

        tags = new ArrayList<Tag>()
        {{
            add(new Tag(1, "mosques", 3, types, 0, null));
            add(new Tag(1, "restaurants", 3, types, 0, null));
            add(new Tag(1, "chalets", 3, types, 0, null));
            add(new Tag(1, "parks", 3, types, 0, null));
            add(new Tag(1, "malls", 3, types, 0, null));
        }};

        prepareBookPager(mTagsPager, tags);
        mCategoriesTabLayout.setupWithViewPager(mTagsPager);
    }

    private void prepareBookPager(ViewPager mBooksPager, List<Tag> tags) {
        //initialize the adapter
        mTabsAdapter = new CategoriesPlacesPager(getSupportFragmentManager());
        //for loop to make new instances from this fragment based on the real data
        for(int i = 0; i<tags.size(); i++){
            Tag tag = tags.get(i);
            mTabsAdapter.addFragment(PlacesFragment.newInstance(tag.getName()), tag.getName());
        }
        mBooksPager.setAdapter(mTabsAdapter);

    }

}