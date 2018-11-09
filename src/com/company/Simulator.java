package com.company;

import java.util.*;

public class Simulator {
    private ArrayList<Route> routes = new ArrayList<Route>();
    private ArrayList<Stop> stops = new ArrayList<Stop>();
    private ArrayList<Bus> buses = new ArrayList<Bus>();
    private PriorityQueue<Event> eventsQueue = new PriorityQueue<>();

    public void process(){
        for (int i = 0; i < 20; i++) {
            Event nextEvent = eventsQueue.remove();
            

            if (nextEvent.getType().equals("move_bus")) {
              int busId = nextEvent.getId();

              for (Bus bus : buses) {
                  if (bus.getId() == busId) {
                      bus.move();
                      Event event = new Event(bus.getTime(), "move_bus", busId);
                      eventsQueue.add(event);
                  }
              }
            }
        }
    }

    public void runCommand(String command, String[] args){

        switch (command) {
            case "add_depot":
                Stop depot = new Stop(Integer.parseInt(args[0]), args[1], 0, Double.parseDouble(args[2]), Double.parseDouble(args[3]));
                stops.add(depot);
                break;
            case "add_stop":
                Stop stop = new Stop(Integer.parseInt(args[0]), args[1], Integer.parseInt(args[2]), Double.parseDouble(args[3]), Double.parseDouble(args[4]));
                stops.add(stop);
                break;
            case "add_route":
                Route route = new Route(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2]);
                routes.add(route);
                break;
            case "extend_route":
                Route routeToExtend = null;
                for (Route route_ : routes) {
                    if (route_.getId() == Integer.parseInt(args[0])) {
                        routeToExtend = route_;
                    }
                }

                if (routeToExtend != null) {
                    for (Stop stopI : stops) {
                        if (stopI.getId() == Integer.parseInt(args[1])) {
                            routeToExtend.extendRoute(stopI);
                        }
                    }
                }
                break;
            case "add_bus":
                Route routeToAdd = null;
                for (Route route__ : routes) {
                    if (route__.getId() == Integer.parseInt(args[1])) {
                        routeToAdd = route__;
                    }
                }

                if (routeToAdd != null) {
                    int location = Integer.parseInt(args[2]);
                    int routeStopsCount = routeToAdd.stopsCount();
                    int nextLocation = location + 1 == routeStopsCount ? 0 : location + 1;

                    Bus bus = new Bus(Integer.parseInt(args[0]), location, nextLocation,Integer.parseInt(args[3]), Integer.parseInt(args[4]),
                            Integer.parseInt(args[5]), Integer.parseInt(args[6]), Integer.parseInt(args[7]), routeToAdd);

                    routeToAdd.addBus(bus);
                    buses.add(bus);
                }
                break;
            case "add_event":
                switch (args[1]) {
                    case "move_bus":
                        for (Bus bus : buses) {
                            if (bus.getId() == Integer.parseInt(args[2])) {
                                bus.setTime(Integer.parseInt(args[0]));
                                eventsQueue.add(new Event(Integer.parseInt(args[0]), args[1], Integer.parseInt(args[2])));
                            }
                        }
                        break;
                }
                break;
        }
    }
}