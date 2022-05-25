package me.whiteship.refactoring._11_primitive_obsession._30_repliace_primitive_with_object;

import java.util.List;

public class Order {

    private Priority priority;
    
    public Order(Priority priority) {
        this.priority = priority;
    }

    public Order(String value) {
    	this.priority = new Priority(value);
	}

	public String getPriority() {
        return priority.toString();
    }
}
