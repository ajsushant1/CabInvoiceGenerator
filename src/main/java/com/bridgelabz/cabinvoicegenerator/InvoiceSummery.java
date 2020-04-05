package com.bridgelabz.cabinvoicegenerator;

import java.util.Objects;

public class InvoiceSummery {
    public int NumberOfRides;
    public double totalFare;
    public double averageFarePerRides;

    public InvoiceSummery(int NumberOfRides, double totalFare) {
        this.NumberOfRides = NumberOfRides;
        this.totalFare = totalFare;
        this.averageFarePerRides = totalFare / NumberOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummery summery = (InvoiceSummery) o;
        return NumberOfRides == summery.NumberOfRides &&
                Double.compare(summery.totalFare, totalFare) == 0 &&
                Double.compare(summery.averageFarePerRides, averageFarePerRides) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(NumberOfRides, totalFare, averageFarePerRides);
    }
}
