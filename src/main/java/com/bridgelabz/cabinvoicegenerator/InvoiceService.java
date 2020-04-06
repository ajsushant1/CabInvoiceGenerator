package com.bridgelabz.cabinvoicegenerator;

public class InvoiceService {

    //CONSTANTS
    private static final double COST_PER_KILOMETER = 10;
    private static final int COST_PER_MINUTE = 1;
    private static final int MINIMUM_FARE = 5;
    private static final double PREMIUM_COST_PER_KILOMETER = 15;
    private static final int PREMIUM_COST_PER_MINUTE = 2;
    private static final int PREMIUM_MINIMUM_FARE = 20;
    RideRepository rideRepository;

    public InvoiceService() {
        this.rideRepository = new RideRepository();
    }

    public static void main(String[] args) {
        System.out.println("/**************************/ WELCOME TO CAB INVOICE GENERATOR /**************************/");
    }

    //METHOD TO CALCULATE TOTAL FARE FOR JOURNEY
    public double calculateTotalFare(Rides[] rides) {
        double totalFare = 0, rideFare;
        for (Rides ride : rides) {
            rideFare = 0;
            if (ride.rideType.equals(Rides.RideType.NORMAL)) {
                rideFare = ride.distanceInKm * COST_PER_KILOMETER + ride.journeyTimeInMinutes * COST_PER_MINUTE;
                totalFare += Math.max(MINIMUM_FARE, rideFare);
            }
            if (ride.rideType.equals(Rides.RideType.PREMIUM)) {
                rideFare += ride.distanceInKm * PREMIUM_COST_PER_KILOMETER + ride.journeyTimeInMinutes * PREMIUM_COST_PER_MINUTE;
                totalFare += Math.max(PREMIUM_MINIMUM_FARE, rideFare);
            }
        }
        return totalFare;
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
