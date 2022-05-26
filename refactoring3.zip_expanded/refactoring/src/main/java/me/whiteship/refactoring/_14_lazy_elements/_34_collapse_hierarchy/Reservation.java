package me.whiteship.refactoring._14_lazy_elements._34_collapse_hierarchy;

import java.util.List;

public class Reservation {

	private List<String> members;
	private String owner;
	private boolean paid;
	public List<String> getMembers() {
		return members;
	}
	public void setMembers(List<String> members) {
		this.members = members;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	
	
}
