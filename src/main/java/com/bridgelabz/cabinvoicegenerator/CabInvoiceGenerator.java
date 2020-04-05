package com.bridgelabz.cabinvoicegenerator;

public class CabInvoiceGenerator {

    //CONSTANTS
    private static final double COST_PER_KILOMETER = 10;
    private static final int COST_PER_MINUTE = 1;
    private static final int MINIMUM_FARE = 5;

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

    public InvoiceSummery getInvoiceSummery(Rides[] rides) {
        double totalFare = calculateTotalFare(rides);
        return new InvoiceSummery(rides.length, totalFare);
    }
}
