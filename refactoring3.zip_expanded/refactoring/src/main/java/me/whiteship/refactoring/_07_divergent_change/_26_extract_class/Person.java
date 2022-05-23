package me.whiteship.refactoring._07_divergent_change._26_extract_class;

public class Person {

    private String name;

    private TelephoneNumber telephoneNumber;
    
	public Person(String name, TelephoneNumber telephoneNumber) {
		this.name = name;
		this.telephoneNumber = telephoneNumber;
	}

	public String getOfficeNumber(TelephoneNumber telephoneNumber) {
		return telephoneNumber.getTelephoneNumber();
	}
	
    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
