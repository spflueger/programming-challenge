package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.Map;
import java.util.stream.Stream;

import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CSVParseTest {
    private final Map<String, String> column_mapping = Map.of(
        "Day", "day",  
        "MxT", "maximum_temperature", 
        "MnT", "minimum_temperature"
    );

    @Test
    void readCSVFileTest() throws FileNotFoundException, CsvRequiredFieldEmptyException {
        String filepath = "./src/main/resources/de/exxcellent/challenge/weather.csv";
 
        FileReader reader = new FileReader(filepath);
        Stream<WeatherDataPoint> weather_data_points = CSVConnector.createDataStream(reader, column_mapping);
    
        WeatherDataPoint first_entry = weather_data_points.iterator().next();
        assertEquals(1, first_entry.getDay());
        assertEquals(88.0, first_entry.getMaximumTemperature());
        assertEquals(59.0, first_entry.getMinimumTemperature());
    }

    @Test
    void formatTest() {
        String csv_string = "MxT,MnT;\n1,32,10";

        StringReader reader = new StringReader(csv_string);

        assertThrows(
            RuntimeException.class, 
            () -> CSVConnector.createDataStream(reader, column_mapping)
        );
    }
}
