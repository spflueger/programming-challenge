package de.exxcellent.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DataProcessingTest {
    @ParameterizedTest(name = "{index} => test_array={0}, expected_result={1}")
    @MethodSource("weatherDataProvider")
    void testMinMaxTemperatureDifferenceComparator(List<WeatherDataPoint> test_array, int expected_result) {

        int result = test_array.stream().min(DataProcessing.Comparators.MinMaxTemperaturDifference).map(x->x.getDay()).orElse(-1);
        assertEquals(expected_result, result);
    }

    private static Stream<Arguments> weatherDataProvider() {
        return Stream.of(
                Arguments.of(
                    Arrays.asList(
                        new WeatherDataPoint(0, 32, 10),
                        new WeatherDataPoint(1, 33, 10)
                    ), 
                    0
                ),
                Arguments.of(
                    Arrays.asList(
                        new WeatherDataPoint(0, 54, 10),
                        new WeatherDataPoint(1, 99, 80)
                    ), 
                    1
                ),
                Arguments.of(
                    Arrays.asList(
                        new WeatherDataPoint(0, 32, 10),
                        new WeatherDataPoint(1, 33, 10),
                        new WeatherDataPoint(5, -10, -20),
                        new WeatherDataPoint(3, 75, 48)
                    ), 
                    5
                )
        );
    }

    @ParameterizedTest(name = "{index} => test_array={0}, expected_result={1}")
    @MethodSource("footballStatsProvider")
    void testAbsoluteGoalDifferenceComparator(List<FootballTeamStats> test_array, String expected_result) {

        String result = test_array.stream().min(DataProcessing.Comparators.AbsGoalsDifference).map(x->x.getTeamName()).orElse("Not Found!");
        assertEquals(expected_result, result);
    }

    private static Stream<Arguments> footballStatsProvider() {
        return Stream.of(
                Arguments.of(
                    Arrays.asList(
                        new FootballTeamStats("Team1", 21, 14),
                        new FootballTeamStats("Team3", 50, 45)
                    ), 
                    "Team3"
                ),
                Arguments.of(
                    Arrays.asList(
                        new FootballTeamStats("Team1", 10, 14),
                        new FootballTeamStats("Team2", 50, 32)
                    ), 
                    "Team1"
                ),
                Arguments.of(
                    Arrays.asList(
                        new FootballTeamStats("Team1", 19, 8),
                        new FootballTeamStats("Team2", 65, 19),
                        new FootballTeamStats("Team3", 24, 18),
                        new FootballTeamStats("Team4", 37, 43)
                    ), 
                    "Team3"
                )
        );
    }
}
