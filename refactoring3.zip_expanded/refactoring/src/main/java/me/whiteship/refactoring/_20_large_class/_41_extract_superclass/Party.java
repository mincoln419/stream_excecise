package me.whiteship.refactoring._20_large_class._41_extract_superclass;

public abstract class Party {

	private String name;

	public String getName() {
	    return name;
	}

	public double annualCost() {
	    return this.monthlyCost() * 12;
	}

	public abstract double monthlyCost();

}
