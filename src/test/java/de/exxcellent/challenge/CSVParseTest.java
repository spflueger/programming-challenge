package de.exxcellent.challenge;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.opencsv.exceptions.CsvRequiredFieldEmptyException;


class CSVParseTest {
    private final Map<String, String> column_mapping = Map.of(
        "Day", "day",  
        "MxT", "maximum_temperature", 
        "MnT", "minimum_temperature"
    );

    @Test
    void readWeatherCSVFileTest() throws FileNotFoundException, CsvRequiredFieldEmptyException {
        String filepath = "./src/main/resources/de/exxcellent/challenge/weather.csv";
 
        FileReader reader = new FileReader(filepath);
        Stream<WeatherDataPoint> weather_data_points = CSVConnector.createDataStream(reader, WeatherDataPoint.class, column_mapping);
    
        WeatherDataPoint first_entry = weather_data_points.iterator().next();
        assertEquals(1, first_entry.getDay());
        assertEquals(88.0, first_entry.getMaximumTemperature());
        assertEquals(59.0, first_entry.getMinimumTemperature());
    }

    @Test
    void readFootballCSVFileTest() throws FileNotFoundException, CsvRequiredFieldEmptyException {
        FileReader reader = new FileReader("./src/main/resources/de/exxcellent/challenge/football.csv");

        Map<String, String> column_mapping = Map.of(
            "Team", "team_name",  
            "Goals", "goals_scored", 
            "Goals Allowed", "goals_allowed"
        );
        Stream<FootballTeamStats> football_team_stats = CSVConnector.createDataStream(
            reader, FootballTeamStats.class, column_mapping);
        FootballTeamStats first_entry = football_team_stats.iterator().next();
        assertEquals("Arsenal", first_entry.getTeamName());
        assertEquals(79, first_entry.getGoalsScored());
        assertEquals(36, first_entry.getGoalsAllowed());
    }

    @Test
    void formatTest() {
        String csv_string = "MxT,MnT;\n1,32,10";

        StringReader reader = new StringReader(csv_string);

        assertThrows(
            RuntimeException.class, 
            () -> CSVConnector.createDataStream(reader, WeatherDataPoint.class, column_mapping)
        );
    }
}
