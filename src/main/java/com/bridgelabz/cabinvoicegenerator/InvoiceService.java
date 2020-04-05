package com.bridgelabz.cabinvoicegenerator;

public class InvoiceService {

    //CONSTANTS
    private static final double COST_PER_KILOMETER = 10;
    private static final int COST_PER_MINUTE = 1;
    private static final int MINIMUM_FARE = 5;
    RideRepository rideRepository;

    public InvoiceService() {
        this.rideRepository = new RideRepository();
    }

    public static void main(String[] args) {
        System.out.println("/**************************/ WELCOME TO CAB INVOICE GENERATOR /**************************/");
    }

    //METHOD TO CALCULATE TOTAL FARE FOR JOURNEY
    public double calculateTotalFare(Rides[] rides) {
        double totalFare = 0;
        for (Rides ride : rides) {
            totalFare += ride.distanceInKm * COST_PER_KILOMETER + ride.journeyTimeInMinutes * COST_PER_MINUTE;
        }
        return Math.max(totalFare, MINIMUM_FARE);
    }

    //METHOD TO GET INVOICE SUMMERY
    public InvoiceSummery getInvoiceSummery(String userId) {
        Rides[] rideList = rideRepository.getRideList(userId);
        double totalFare = calculateTotalFare(rideList);
        return new InvoiceSummery(rideList.length, totalFare);
    }

    //METHOD TO ADD RIDE LIST
    public void addRides(String userId, Rides[] rides) {
        rideRepository.addRide(userId, rides);
    }
}
