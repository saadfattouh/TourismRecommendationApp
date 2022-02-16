package com.example.tourismrecommendationapp.model;

public class place {
    private int id;
    private int tagName;
    private String name;
    private String numOfVisits;

    public place(int id, int tagName, String name, String numOfVisits) {
        this.id = id;
        this.tagName = tagName;
        this.name = name;
        this.numOfVisits = numOfVisits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTagName() {
        return tagName;
    }

    public void setTagName(int tagName) {
        this.tagName = tagName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumOfVisits() {
        return numOfVisits;
    }

    public void setNumOfVisits(String numOfVisits) {
        this.numOfVisits = numOfVisits;
    }
}
