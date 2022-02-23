package com.example.tourismrecommendationapp.model;

public class tagSpecific {
    private int id;
    private int tagId;
    private int name;

    public tagSpecific(int id, int tagId, int name) {
        this.id = id;
        this.tagId = tagId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getTagId() {
        return tagId;
    }

    public int getName() {
        return name;
    }
}
