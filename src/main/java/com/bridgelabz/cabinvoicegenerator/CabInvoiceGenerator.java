package com.bridgelabz.cabinvoicegenerator;

public class CabInvoiceGenerator {
    private static final double COST_PER_KILOMETER = 10;
    private static final int COST_PER_MINUTE = 1;

    public static void main(String[] args) {
        System.out.println("/**************************/ WELCOME TO CAB INVOICE GENERATOR /**************************/");
    }

    public double calculateTotalFare(double distanceInKm, int journeyTimeInMinutes) {
        double totalFare = distanceInKm * COST_PER_KILOMETER + journeyTimeInMinutes * COST_PER_MINUTE;
        return totalFare;
    }
}
