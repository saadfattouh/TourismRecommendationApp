package com.example.tourismrecommendationapp.model;

public class place {
    private int id;
    private int tagName;
    private String name;
    private String region;
    private String image;
    private double lat;
    private double lon;

    public place(int id, int tagName, String name, String region, String image, double lat, double lon) {
        this.id = id;
        this.tagName = tagName;
        this.name = name;
        this.region = region;
        this.image = image;
        this.lat = lat;
        this.lon = lon;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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
}
