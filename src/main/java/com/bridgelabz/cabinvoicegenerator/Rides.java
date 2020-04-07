package com.bridgelabz.cabinvoicegenerator;

public class Rides {
    public double distanceInKm;
    public int journeyTimeInMinutes;
    RideType rideType;

    public Rides(RideType rideType, double distanceInKm, int journeyTimeInMinutes) {
        this.rideType = rideType;
        this.distanceInKm = distanceInKm;
        this.journeyTimeInMinutes = journeyTimeInMinutes;
    }
}
