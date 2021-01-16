package de.exxcellent.challenge;

import java.util.Comparator;

public class DataProcessing {
    public static class Comparators {
        public static Comparator<FootballTeamStats> AbsGoalsDifference = Comparator.comparing((FootballTeamStats x) -> Math.abs(x.getGoalsScored() - x.getGoalsAllowed()));
        public static Comparator<WeatherDataPoint> MinMaxTemperaturDifference = Comparator.comparing((WeatherDataPoint x) -> x.getMaximumTemperature() - x.getMinimumTemperature());
    }
}
