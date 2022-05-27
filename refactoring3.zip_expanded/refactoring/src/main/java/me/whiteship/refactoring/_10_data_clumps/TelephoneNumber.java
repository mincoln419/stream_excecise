package me.whiteship.refactoring._10_data_clumps;

public class TelephoneNumber {
	private String officeAreCode;
	private String officeNumber;

	public TelephoneNumber() {
	}

	public String getOfficeAreCode() {
		return officeAreCode;
	}

	public void setOfficeAreCode(String officeAreCode) {
		this.officeAreCode = officeAreCode;
	}

	public String getOfficeNumber() {
		return officeNumber;
	}

	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}
}