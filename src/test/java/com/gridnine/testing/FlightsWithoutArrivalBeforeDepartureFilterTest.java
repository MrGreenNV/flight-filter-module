package com.gridnine.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for FlightsWithoutArrivalBeforeDepartureFilter.
 * @author mrGreenNV
 */
class FlightsWithoutArrivalBeforeDepartureFilterTest {

    private List<Flight> testFlights;
    private Flight flightWithCorrectTestSegments;
    private Flight flightWithIncorrectTestSegments;

    /**
     * Initialize items.
     */
    @BeforeEach
    public void setUp() {
        testFlights = new ArrayList<>(2);

        flightWithCorrectTestSegments = createFlightWithCorrectSegments();
        flightWithIncorrectTestSegments = createFlightWithIncorrectSegments();

        testFlights.add(flightWithCorrectTestSegments);
        testFlights.add(flightWithIncorrectTestSegments);
    }

    /**
     * Checks filtering with a FlightsWithoutArrivalBeforeDepartureFilter strategy.
     */
    @Test
    public void testFilter() {
        FilterStrategy filterStrategy = new FlightsWithoutArrivalBeforeDepartureFilter();

        List<Flight> filteredFlights = filterStrategy.filter(testFlights);

        assertEquals(1, filteredFlights.size());
        assertTrue(filteredFlights.contains(flightWithCorrectTestSegments));
        assertFalse(filteredFlights.contains(flightWithIncorrectTestSegments));
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
        return new Flight(List.of(new Segment(time, time.minusHours(2))));
    }
}