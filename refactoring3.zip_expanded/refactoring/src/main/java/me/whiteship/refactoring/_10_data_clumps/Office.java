package me.whiteship.refactoring._10_data_clumps;

public class Office {

	private String location;

	private TelephoneNumber officeNumber;

	public Office(String location, TelephoneNumber officeNumber) {
		this.location = location;
		this.officeNumber = officeNumber;
	}

	public String officePhoneNumber() {
		return officeNumber.getOfficeAreCode() + "-" + officeNumber.getOfficeNumber();
	}

}
