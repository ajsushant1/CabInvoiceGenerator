package com.bridgelabz.cabinvoicegeneratortest;

import com.bridgelabz.cabinvoicegenerator.InvoiceService;
import com.bridgelabz.cabinvoicegenerator.InvoiceSummery;
import com.bridgelabz.cabinvoicegenerator.Rides;
import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
    InvoiceService cabInvoiceGenerator = new InvoiceService();

    @Test
    public void givenDistanceAndTime_GenerateTotalFare_ShouldReturnTheTotalFareForTheJourney() {
        Rides[] rides = {new Rides(10.55, 30)};
        double totalFare = cabInvoiceGenerator.calculateTotalFare(rides);
        Assert.assertEquals(135.5, totalFare, 0);
    }

    @Test
    public void givenDistanceAndTime_WhenTotalFareLessThanMinimumFare_ShouldReturnFixedMinimumFare() {
        Rides[] rides = {new Rides(0.195, 2)};
        double totalFare = cabInvoiceGenerator.calculateTotalFare(rides);
        Assert.assertEquals(5, totalFare, 0);
    }

    @Test
    public void givenMultipleRides_GenerateTotalFare_ShouldReturnTheTotalFareForTheJourney() {
        Rides[] rides = {new Rides(35.0, 45), new Rides(10.55, 30)};
        double totalFare = cabInvoiceGenerator.calculateTotalFare(rides);
        Assert.assertEquals(530.5, totalFare, 0);
    }

    @Test
    public void givenMultipleRides_GenerateTotalFare_ShouldReturnInvoiceSummery() {
        Rides[] rides = {new Rides(35.0, 45), new Rides(10.55, 30)};
        cabInvoiceGenerator.addRides("user@1", rides);
        InvoiceSummery invoiceSummery = cabInvoiceGenerator.getInvoiceSummery("user@1");
        InvoiceSummery expectedSummery = new InvoiceSummery(2, 530.5);
        Assert.assertEquals(expectedSummery, invoiceSummery);
    }

    @Test
    public void givenUserId_GenerateTotalFare_ShouldReturnInvoiceSummery() {
        Rides[] rides = {new Rides(35.0, 45), new Rides(10.55, 30), new Rides(20, 30)};
        cabInvoiceGenerator.addRides("user@1", rides);
        InvoiceSummery invoiceSummery = cabInvoiceGenerator.getInvoiceSummery("user@1");
        InvoiceSummery expectedSummery = new InvoiceSummery(3, 760.5);
        Assert.assertEquals(expectedSummery, invoiceSummery);
    }
}
