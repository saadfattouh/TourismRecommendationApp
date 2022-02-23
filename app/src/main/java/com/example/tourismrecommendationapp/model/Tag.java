package com.example.tourismrecommendationapp.model;

import java.util.ArrayList;

public class Tag {

    private int id;
    private String name;
    private String image;
    private int numOfTypes;
    private ArrayList<String> placeTypesList;
    private int selectedType;

    public Tag(int id, String name) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Tag(int id, String name, int numOfTypes, ArrayList<String> types, int selectedType, String image) {
        this.id = id;
        this.name = name;
        this.numOfTypes = numOfTypes;
        this.placeTypesList = types;
        this.selectedType = selectedType;
    }

    public Tag(int id, String name, ArrayList<String> placeTypesList, int selectedType) {
        this.id = id;
        this.name = name;
        this.placeTypesList = placeTypesList;
        this.selectedType = selectedType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfTypes() {
        return numOfTypes;
    }

    public ArrayList<String> getPlaceTypesList() {
        return placeTypesList;
    }

    public void setPlaceTypesList(ArrayList<String> placeTypesList) {
        this.placeTypesList = placeTypesList;
    }

    public int getSelectedType() {
        return selectedType;
    }

    public void setNumOfTypes(int numOfTypes) {
        this.numOfTypes = numOfTypes;
    }



    public void setSelectedType(int selectedType) {
        this.selectedType = selectedType;
    }
}
