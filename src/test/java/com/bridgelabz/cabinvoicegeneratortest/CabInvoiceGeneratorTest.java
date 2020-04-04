package com.bridgelabz.cabinvoicegeneratortest;

import com.bridgelabz.cabinvoicegenerator.CabInvoiceGenerator;
import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
    CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();

    @Test
    public void givenDistanceAndTime_GenerateTotalFare_ShouldReturnTheTotalFareForTheJourney() {
        double totalFare = cabInvoiceGenerator.calculateTotalFare(10.55, 30);
        Assert.assertEquals(135.5, totalFare, 0);
    }
}
