package com.company;

public class Stop {
    private int id;
    private String name;
    private int passengers;
    private Double latitude;
    private Double longitide;

    public Stop(int id, String name, int passengers, double latitude, double longitide) {
        this.id = id;
        this.name = name;
        this.passengers = passengers;
        this.latitude = latitude;
        this.longitide = longitide;
    }

    public int getId(){
        return id;
    }

    public Double getLatitude(){
        return latitude;
    }

    public Double getLongitude(){
        return longitide;
    }
}
