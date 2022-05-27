package me.whiteship.refactoring._20_large_class._41_extract_superclass;

public class Employee extends Party {

    private Integer id;

    private double monthlyCost;

    public double annualCost() {
        return this.monthlyCost * 12;
    }

    public Integer getId() {
        return id;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }
}
