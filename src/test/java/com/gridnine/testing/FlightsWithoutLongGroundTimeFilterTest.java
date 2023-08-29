package com.gridnine.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for FlightsWithoutLongGroundTimeFilter.
 * @author mrGreenNV
 */
class FlightsWithoutLongGroundTimeFilterTest {

    private List<Flight> testFlights;
    private Flight flightWithCorrectTestSegments;
    private Flight flightWithIncorrectTestSegments;

    @BeforeEach
    public void setUp() {
        testFlights = new ArrayList<>(2);

        flightWithCorrectTestSegments = createFlightWithCorrectSegments();
        flightWithIncorrectTestSegments = createFlightWithIncorrectSegments();

        testFlights.add(flightWithCorrectTestSegments);
        testFlights.add(flightWithIncorrectTestSegments);
    }

    /**
     * Checks filtering with a FlightsWithoutLongGroundTimeFilter strategy.
     */
    @Test
    public void testFilter() {
        FilterStrategy filterStrategy = new FlightsWithoutLongGroundTimeFilter();

        List<Flight> filteredFlights = filterStrategy.filter(testFlights);

        assertEquals(1, filteredFlights.size());
        assertTrue(filteredFlights.contains(flightWithCorrectTestSegments));
        assertFalse(filteredFlights.contains(flightWithIncorrectTestSegments));

    }

    /**
     * Checks for throwing an TimeSpentOnEarthException.
     */
    @Test
    public void testFilter_throwTimeSpentOnEarthException() {
        RuntimeException exception = assertThrows(TimeSpentOnEarthException.class, () -> new FlightsWithoutLongGroundTimeFilter(-5));

        assertEquals(TimeSpentOnEarthException.class, exception.getClass());
        assertEquals("The time spent on earth cannot be negative", exception.getMessage());
    }

    /**
     * Creating object Flight with correct segments;
     * @return object Flight.
     */
    private Flight createFlightWithCorrectSegments() {
        LocalDateTime time = LocalDateTime.now();
        return new Flight(List.of(new Segment(time.plusHours(2), time.plusHours(4))));
    }

    /**
     * Creating object Flight with incorrect segments;
     * @return object Flight.
     */
    private Flight createFlightWithIncorrectSegments() {
        LocalDateTime time = LocalDateTime.now();
        return new Flight(List.of(new Segment(time, time.plusHours(2)), new Segment(time.plusHours(8), time.plusHours(10))));
    }

}