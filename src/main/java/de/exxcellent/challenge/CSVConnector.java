package de.exxcellent.challenge;

import java.lang.String;
import java.util.stream.Stream;
import java.io.Reader;
import java.util.Map;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

class CSVConnector {  
    public static <T> Stream<T> createDataStream(
        Reader data_reader,
        Class<T> object_class,
        Map<String, String> column_mapping
    ) {
        // Note there is currently no error thrown when the column mapping is not matching the csv file header.
        // Instead the fields are simply assigned the default value.
        HeaderColumnNameTranslateMappingStrategy<T> ms = new HeaderColumnNameTranslateMappingStrategy<>();
        ms.setType(object_class);
        ms.setColumnMapping(column_mapping);

        return new CsvToBeanBuilder<T>(data_reader).withType(object_class).withMappingStrategy(ms).build().stream();
    }
}