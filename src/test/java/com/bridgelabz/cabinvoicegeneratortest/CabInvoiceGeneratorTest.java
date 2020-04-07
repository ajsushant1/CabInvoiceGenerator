package com.bridgelabz.cabinvoicegeneratortest;

import com.bridgelabz.cabinvoicegenerator.InvoiceService;
import com.bridgelabz.cabinvoicegenerator.InvoiceSummery;
import com.bridgelabz.cabinvoicegenerator.RideType;
import com.bridgelabz.cabinvoicegenerator.Rides;
import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
    InvoiceService cabInvoiceGenerator = new InvoiceService();

    @Test
    public void givenDistanceAndTime_GenerateTotalFare_ShouldReturnTheTotalFareForTheJourney() {
        double totalFare = cabInvoiceGenerator.calculateTotalFare(RideType.NORMAL,10.55,30);
        Assert.assertEquals(135.5, totalFare, 0);
    }

    @Test
    public void givenDistanceAndTime_WhenTotalFareLessThanMinimumFare_ShouldReturnFixedMinimumFare() {
        double totalFare = cabInvoiceGenerator.calculateTotalFare(RideType.NORMAL,0.195,2);
        Assert.assertEquals(5, totalFare, 0);
    }

    @Test
    public void givenMultipleRides_GenerateTotalFare_ShouldReturnTheTotalFareForTheJourney() {
        Rides[] rides = {new Rides(RideType.NORMAL,35.0, 45), new Rides(RideType.PREMIUM,10.55, 30)};
        cabInvoiceGenerator.addRides("user@1",rides);
        InvoiceSummery invoiceSummery = cabInvoiceGenerator.getInvoiceSummery("user@1");
        Assert.assertEquals(613.25, invoiceSummery.totalFare, 0);
    }

    @Test
    public void givenMultipleRides_GenerateTotalFare_ShouldReturnInvoiceSummery() {
        Rides[] rides = {new Rides(RideType.NORMAL,35.0, 45), new Rides(RideType.NORMAL,10.55, 30)};
        cabInvoiceGenerator.addRides("user@1", rides);
        InvoiceSummery invoiceSummery = cabInvoiceGenerator.getInvoiceSummery("user@1");
        InvoiceSummery expectedSummery = new InvoiceSummery(2, 530.5);
        Assert.assertEquals(expectedSummery, invoiceSummery);
    }

    @Test
    public void givenUserId_GenerateTotalFare_ShouldReturnInvoiceSummery() {
        Rides[] rides = {new Rides(RideType.PREMIUM,35.0, 45), new Rides(RideType.PREMIUM,10.55, 30), new Rides(RideType.NORMAL,20, 30)};
        cabInvoiceGenerator.addRides("user@1", rides);
        InvoiceSummery invoiceSummery = cabInvoiceGenerator.getInvoiceSummery("user@1");
        InvoiceSummery expectedSummery = new InvoiceSummery(3, 1063.25);
        Assert.assertEquals(expectedSummery, invoiceSummery);
    }

    @Test
    public void givenDistanceAndTimeWithRideCategoryNormal_GenerateTotalFare_ShouldReturnTheTotalFareForTheJourney() {
        Rides[] rides = {new Rides(RideType.NORMAL,21.55, 30)};
        cabInvoiceGenerator.addRides("user@12",rides);
        InvoiceSummery invoiceSummery = cabInvoiceGenerator.getInvoiceSummery("user@12");
        Assert.assertEquals(245.5,invoiceSummery.totalFare,0);
    }

    @Test
    public void givenDistanceAndTimeWithRideCategoryPremium_GenerateTotalFare_ShouldReturnTheTotalFareForTheJourney() {
        Rides[] rides = {new Rides(RideType.PREMIUM,21.55, 30)};
        cabInvoiceGenerator.addRides("user@45",rides);
        InvoiceSummery invoiceSummery = cabInvoiceGenerator.getInvoiceSummery("user@45");
        Assert.assertEquals(383.25,invoiceSummery.totalFare,0);
    }

    @Test
    public void givenMultipleRidesOfTwoDifferentUser_GenerateTotalFareFirstUser_ShouldReturnInvoiceSummery() {
        Rides[] firstUserRides = {new Rides(RideType.NORMAL,35.0, 45), new Rides(RideType.NORMAL,10.55, 30)};
        cabInvoiceGenerator.addRides("user@1", firstUserRides);

        Rides[] secondUserRides = {new Rides(RideType.PREMIUM,35.0, 45), new Rides(RideType.NORMAL,10.55, 30)};
        cabInvoiceGenerator.addRides("user@2", secondUserRides);
        InvoiceSummery invoiceSummery = cabInvoiceGenerator.getInvoiceSummery("user@1");
        InvoiceSummery expectedSummery = new InvoiceSummery(2, 530.5);
        Assert.assertEquals(expectedSummery, invoiceSummery);
    }
}
