package me.whiteship.refactoring._05_global_data._01_before;

public class Thermostats {

    private static Integer targetTemperature = 70;//상수값을 글로벌에 두는 것은 final 이 필요한 경우만...

    private static Boolean heating = true;

    private static Boolean cooling = false;

    private static Boolean fahrenheit = true;

	public static Integer getTargetTemperature() {
		return targetTemperature;
	}

	public static void setTargetTemperature(Integer targetTemperature) {
		Thermostats.targetTemperature = targetTemperature;
	}

	public static Boolean getHeating() {
		return heating;
	}

	public static void setHeating(Boolean heating) {
		Thermostats.heating = heating;
	}

	public static Boolean getCooling() {
		return cooling;
	}

	public static void setCooling(Boolean cooling) {
		Thermostats.cooling = cooling;
	}

	public static Boolean getFahrenheit() {
		return fahrenheit;
	}

	public static void setFahrenheit(Boolean fahrenheit) {
		Thermostats.fahrenheit = fahrenheit;
	}

}
