package com.company;

import java.util.ArrayList;

public class Route {
    private int id;
    private int number;
    private String name;
    private ArrayList<Stop> stops = new ArrayList<Stop>();
    private ArrayList<Bus> busses = new ArrayList<Bus>();

    public Route(int id, int number, String name) {
        this.id = id;
        this.number = number;
        this.name = name;
    }

    public void extendRoute(Stop stop) {
        stops.add(stop);
    }

    public void addBus(Bus bus) {
        busses.add(bus);
    }

    public int getId(){
        return id;
    }

    public ArrayList<Stop> getStops(){
        return stops;
    }

    public int stopsCount(){
        return stops.size();
    }
}


