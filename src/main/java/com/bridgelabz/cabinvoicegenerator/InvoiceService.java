package com.bridgelabz.cabinvoicegenerator;

public class InvoiceService {

    //CONSTANTS
    private static double COST_PER_KILOMETER;
    private static int COST_PER_MINUTE;
    private static int MINIMUM_FARE;
    RideRepository rideRepository;

    public InvoiceService() {
        this.rideRepository = new RideRepository();
    }

    public static void main(String[] args) {
        System.out.println("/**************************/ WELCOME TO CAB INVOICE GENERATOR /**************************/");
    }

    //METHOD TO CALCULATE TOTAL FARE FOR JOURNEY
    public double calculateTotalFare(RideType rideType,double distance,int time) {
        setValue(rideType);
        double totalFare = distance * COST_PER_KILOMETER + time * COST_PER_MINUTE;
        return Math.max(totalFare,MINIMUM_FARE);
    }

    //METHOD TO SET THE RATE OF RIDE CATEGORY
    private void setValue(RideType rideType) {
        COST_PER_KILOMETER=rideType.costPerKilometer;
        COST_PER_MINUTE=rideType.costPerMinute;
        MINIMUM_FARE=rideType.minimumFare;
    }

    //METHOD TO GET INVOICE SUMMERY
    public InvoiceSummery getInvoiceSummery(String userId) {
        return generateInvoiceSummery(rideRepository.getRideList(userId));
    }

    private InvoiceSummery generateInvoiceSummery(Rides[] rideList) {
        double totalFare=0;
        for (Rides rides : rideList){
            totalFare += calculateTotalFare(rides.rideType, rides.distanceInKm, rides.journeyTimeInMinutes);
        }
        return new InvoiceSummery(rideList.length,totalFare);
    }

    //METHOD TO ADD RIDE LIST
    public void addRides(String userId, Rides[] rides) {
        rideRepository.addRide(userId, rides);
    }
}
