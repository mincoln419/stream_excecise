package me.whiteship.refactoring._22_data_class._42_encapsulate_record;

import org.junit.jupiter.api.Test;

class OrganizationTest {

	@Test
	void test() {
		Organization organization = new Organization();
		System.out.println(organization.name);
		
		OranazationRecord oranazationRecord = new OranazationRecord("mermer");
		oranazationRecord.name();
		
	}

}
