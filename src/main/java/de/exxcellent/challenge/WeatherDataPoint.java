package de.exxcellent.challenge;

/// Immutable plain data object which stores weather based data.
public class WeatherDataPoint {
    private int day;
    private float maximum_temperature;
    private float minimum_temperature;

    int getDay() {
        return day;
    }

    float getMaximumTemperature() {
        return maximum_temperature;
    }

    float getMinimumTemperature() {
        return minimum_temperature;
    }
}
