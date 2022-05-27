package me.whiteship.refactoring._06_mutable_data._23_change_reference_to_value;

import java.util.Objects;

public class TelephoneNumber {

    private final String areaCode;

    private final String number;

    public TelephoneNumber(String areaCode, String number) {
		this.areaCode = areaCode;
		this.number = number;
	}

	public String areaCode() {
        return areaCode;
    }
	
    public String number() {
        return number;
    }

	@Override
	public int hashCode() {
		return Objects.hash(areaCode, number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TelephoneNumber other = (TelephoneNumber) obj;
		return Objects.equals(areaCode, other.areaCode) && Objects.equals(number, other.number);
	}

}
