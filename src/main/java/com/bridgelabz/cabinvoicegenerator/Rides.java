package com.bridgelabz.cabinvoicegenerator;

public class Rides {

    public int journeyTimeInMinutes;
    public double distanceInKm;

    public Rides(double distanceInKm, int journeyTimeInMinutes) {
        this.distanceInKm = distanceInKm;
        this.journeyTimeInMinutes = journeyTimeInMinutes;
    }
}
