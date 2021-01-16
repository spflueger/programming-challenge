package de.exxcellent.challenge;

/// Immutable plain data object which stores weather based data.
public class WeatherDataPoint {
    private int day;
    private float maximum_temperature;
    private float minimum_temperature;

    public WeatherDataPoint() {}
    public WeatherDataPoint(int day_, float max_temperature, float min_temperature) {
        day = day_;
        maximum_temperature = max_temperature;
        minimum_temperature = min_temperature;
    }

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
