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

        Map<String, String> column_mapping = Map.of(
            "Day", "day",  
            "MxT", "maximum_temperature", 
            "MnT", "minimum_temperature"
        );
        String filepath = "./src/main/resources/de/exxcellent/challenge/weather.csv";
        try {
            FileReader reader = new FileReader(filepath);
            Stream<WeatherDataPoint> weather_data_points = CSVConnector.createDataStream(reader, WeatherDataPoint.class, column_mapping);
            Optional<WeatherDataPoint> result = weather_data_points.min(
                Comparator.comparing((x) -> x.getMaximumTemperature() - x.getMinimumTemperature()));

            String dayWithSmallestTempSpread = "Not Found!";
            if (result.isPresent()) {
                dayWithSmallestTempSpread = "" + result.get().getDay();
            }
            System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
