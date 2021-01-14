package de.exxcellent.challenge;

import java.lang.String;
import java.util.stream.Stream;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

class CSVConnector {  
    public static Stream<WeatherDataPoint> createDataStream(
        Reader data_reader,
        Map<String, String> column_mapping
    ) throws CsvRequiredFieldEmptyException {
        // Note there is currently no error thrown when the column mapping is not matching the csv file header.
        // Instead the fields are simply assigned the default value.
        HeaderColumnNameTranslateMappingStrategy<WeatherDataPoint> ms = new HeaderColumnNameTranslateMappingStrategy<>();
        ms.setType(WeatherDataPoint.class);
        ms.setColumnMapping(column_mapping);

        List<WeatherDataPoint> weather_data_points = new CsvToBeanBuilder<WeatherDataPoint>(
            data_reader
        ).withType(WeatherDataPoint.class).withMappingStrategy(ms).build().parse();
        return weather_data_points.stream();
    }
}