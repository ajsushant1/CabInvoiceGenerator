package com.bridgelabz.cabinvoicegeneratortest;

import com.bridgelabz.cabinvoicegenerator.CabInvoiceGenerator;
import com.bridgelabz.cabinvoicegenerator.InvoiceSummery;
import com.bridgelabz.cabinvoicegenerator.Rides;
import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
    CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();

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
        InvoiceSummery invoiceSummery = cabInvoiceGenerator.getInvoiceSummery(rides);
        InvoiceSummery expectedSummery = new InvoiceSummery(2, 530.5);
        Assert.assertEquals(expectedSummery, invoiceSummery);
    }
}
