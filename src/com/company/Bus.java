package com.company;

public class Bus {
    private int id;
    private int location;
    private int nextLocation;
    private int capacity;
    private int passengers;
    private int fuel;
    private int fuelCapacity;
    private int speed;
    private int time;
    private Route route;

    public Bus(int id, int location, int nextLocation, int capacity, int passengers, int fuel, int fuelCapacity, int speed, Route route) {
        this.id = id;
        this.location = location;
        this.nextLocation = nextLocation;
        this.capacity = capacity;
        this.passengers = passengers;
        this.fuel = fuel;
        this.fuelCapacity = fuelCapacity;
        this.speed = speed;
        this.route = route;
        this.time = 0;
    }

    public int getId(){
        return this.id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void move(){
        this.time = time + nextLocationTravelTime();
        System.out.println("b:" + id + "->s:" + getNextStop().getId() + "@" + time + "//p:" + 0 + "/f:" + 0);
        updateNextLocation();
    }

    private Stop getStop(){
        return route.getStops().get(location);
    }

    private Stop getNextStop(){
        return route.getStops().get(nextLocation);
    }

    private int nextLocationDistance(){
        Stop stop = getStop();
        Stop nextStop = getNextStop();

        Double distance = 70.0 * Math.sqrt(Math.pow((stop.getLatitude() -
                nextStop.getLatitude()), 2) + Math.pow((stop.getLongitude() - nextStop.getLongitude()), 2));

        return distance.intValue();
    }

    private int nextLocationTravelTime(){
        return 1 + (nextLocationDistance() * 60 / speed);
    }

    private void updateNextLocation(){
        this.location = nextLocation;
        this.nextLocation = nextLocation + 1 == route.stopsCount() ? 0 : nextLocation + 1;
    }
}

