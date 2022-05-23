package me.whiteship.refactoring._07_divergent_change._26_extract_class;

public class TelephoneNumber {
	
	
	private String areaCode;
	private String number;

	
	public TelephoneNumber(String areaCode, String number) {
		this.areaCode = areaCode;
		this.number = number;
	}

	public String getTelephoneNumber() {
        return this.getAreaCode() + " " + this.getNumber();
    }
	
	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String officeAreaCode) {
		this.areaCode = officeAreaCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String officeNumber) {
		this.number = officeNumber;
	}
}