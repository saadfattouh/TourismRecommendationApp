package com.example.tourismrecommendationapp.model;

public class Place {

    private int id;
    private String tagName;
    private String name;
    private String region;
    private String image;
    private double lat;
    private double lon;
    private double rating;

    public Place(int id, String tagName, String name, String region, String image, double lat, double lon) {
        this.id = id;
        this.tagName = tagName;
        this.name = name;
        this.region = region;
        this.image = image;
        this.lat = lat;
        this.lon = lon;
    }

    public Place(int id, String tagName, String name, String region, String image, double lat, double lon, double rating) {
        this.id = id;
        this.tagName = tagName;
        this.name = name;
        this.region = region;
        this.image = image;
        this.lat = lat;
        this.lon = lon;
        this.rating = rating;
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

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }
}
