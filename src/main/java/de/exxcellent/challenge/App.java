package de.exxcellent.challenge;

import java.io.FileReader;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {



    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
        try {
            Map<String, String> column_mapping = Map.of(
                "Day", "day",  
                "MxT", "maximum_temperature", 
                "MnT", "minimum_temperature"
            );
            FileReader reader = new FileReader("./src/main/resources/de/exxcellent/challenge/weather.csv");
            Stream<WeatherDataPoint> weather_data_points = CSVConnector.createDataStream(reader, WeatherDataPoint.class, column_mapping);
            Optional<WeatherDataPoint> result = weather_data_points.min(DataProcessing.Comparators.MinMaxTemperaturDifference);

            String dayWithSmallestTempSpread = result.map(x -> Integer.toString(x.getDay())).orElse("Not Found!");
            System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Map<String, String> column_mapping = Map.of(
                "Team", "team_name",  
                "Goals", "goals_scored", 
                "Goals Allowed", "goals_allowed"
            );
            FileReader reader = new FileReader("./src/main/resources/de/exxcellent/challenge/football.csv");
            Stream<FootballTeamStats> weather_data_points = CSVConnector.createDataStream(reader, FootballTeamStats.class, column_mapping);
            Optional<FootballTeamStats> result = weather_data_points.min(DataProcessing.Comparators.AbsGoalsDifference);

            String teamWithSmallestGoalSpread = result.map(x -> x.getTeamName()).orElse("Not Found!");
            System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
