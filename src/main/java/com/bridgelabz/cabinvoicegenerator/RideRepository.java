package com.bridgelabz.cabinvoicegenerator;

import java.util.HashMap;
import java.util.Map;

public class RideRepository {
    Map<String, Rides[]> rideList;

    public RideRepository() {
        this.rideList = new HashMap<>();
    }

    public void addRide(String userId, Rides[] rides) {
        Rides[] ridesList = rideList.get(userId);
        if (ridesList == null)
            rideList.put(userId, rides);
    }

    public Rides[] getRideList(String userId) {
        return rideList.get(userId);
    }
}
