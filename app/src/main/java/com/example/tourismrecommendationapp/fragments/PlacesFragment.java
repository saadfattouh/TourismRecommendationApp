package com.example.tourismrecommendationapp.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import com.example.tourismrecommendationapp.R;
import com.example.tourismrecommendationapp.adapters.PlacesAdapter;
import com.example.tourismrecommendationapp.model.Place;

import java.util.ArrayList;
import java.util.List;

public class PlacesFragment extends Fragment {

    RecyclerView mList;
    PlacesAdapter mAdapter;
    ArrayList<Place> Places;

    EditText mSearchEditText;

    //to handle search queries
    String query = "";

    //todo send this with new instance
    int tagId;

    // for different language approaches
    private String mTagName;

    private static final String TAG_KEY = "tagKey";

    public PlacesFragment() {
        // Required empty public constructor
    }


    public static PlacesFragment newInstance(String tagName) {
        PlacesFragment fragment = new PlacesFragment();
        Bundle args = new Bundle();
        args.putString(TAG_KEY, tagName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mTagName = getArguments().getString(TAG_KEY);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //initialize view parent
        View view = inflater.inflate(R.layout.fragment_places, container, false);

//        //binding
        mList = view.findViewById(R.id.rv_places);
        mSearchEditText = view.findViewById(R.id.search_edit_text);

//        //working with search edit text.
//        //changing label of "enter" button into search instead
//        mSearchEditText.setImeActionLabel("Search", KeyEvent.KEYCODE_ENTER);
//
//        mSearchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
//                if (event==null) {
//                    query = mSearchEditText.getText().toString();
//                    if (actionId==EditorInfo.IME_ACTION_DONE){}
//                        // Capture soft enters in a singleLine EditText that is the last EditText.
////                        gotoSearchResultsActivity(query);
//                    else if (actionId==EditorInfo.IME_ACTION_NEXT){}
//                        // Capture soft enters in other singleLine EditTexts
////                        gotoSearchResultsActivity(query);
//                    else return false;  // Let system handle all other null KeyEvents
//                }
//
//                else
//                    return false;
//
//                return false;
//            }
//        });




        //now displaying  books based on the chosen category
//        //progressBar
//        //todo make a better way for loading visualisation
//        final ProgressDialog progressDialog = new ProgressDialog(getContext());
//        progressDialog.setMessage("Please Wait...");
//        progressDialog.show();


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getPlacesByTag(tagId);
    }

    private void getPlacesByTag(int tagId) {
        Places = new ArrayList<Place>(){{
            add(new Place(1, "mousque", "alrahman mousque", "alqaseem", null, 0.44423, 0.3243));
            add(new Place(1, "mousque", "alrahman mousque", "alqaseem", null, 0.44423, 0.3243));
            add(new Place(1, "mousque", "alrahman mousque", "alqaseem", null, 0.44423, 0.3243));
            add(new Place(1, "mousque", "alrahman mousque", "alqaseem", null, 0.44423, 0.3243));
            add(new Place(1, "mousque", "alrahman mousque", "alqaseem", null, 0.44423, 0.3243));
            add(new Place(1, "mousque", "alrahman mousque", "alqaseem", null, 0.44423, 0.3243));
            add(new Place(1, "mousque", "alrahman mousque", "alqaseem", null, 0.44423, 0.3243));
            add(new Place(1, "mousque", "alrahman mousque", "alqaseem", null, 0.44423, 0.3243));

        }};

        mAdapter = new PlacesAdapter(getContext(), Places);
        mList.setAdapter(mAdapter);
    }
}