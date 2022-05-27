package me.whiteship.refactoring._10_data_clumps;

public class Employee {

    private String name;

    private TelephoneNumber telephoneNumber;

    public Employee(String name, TelephoneNumber telephoneNumber) {
		super();
		this.name = name;
		this.telephoneNumber = telephoneNumber;
	}

	public String personalPhoneNumber() {
        return telephoneNumber.getOfficeAreCode() + "-" + telephoneNumber.getOfficeNumber();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
