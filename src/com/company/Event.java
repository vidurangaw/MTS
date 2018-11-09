package com.company;

public class Event implements Comparable<Event>{
    private int time;
    private String type;
    private int id;

    public Event(int time, String type, int id) {
        this.time = time;
        this.type = type;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int compareTo(Event event){
        return this.time > event.time ? 1 : this.time < event.time ? -1 : 0;
    }
}
