package me.whiteship.refactoring._03_long_function._08_introdce_parameter_object;

public class ParticpantPrinter {
	public int totalNumberOfEvents;
	public Participant p;

	public ParticpantPrinter(int totalNumberOfEvents, Participant p) {
		this.totalNumberOfEvents = totalNumberOfEvents;
		this.p = p;
	}
}