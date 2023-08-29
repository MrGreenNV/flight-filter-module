package com.gridnine.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for FlightsWithoutDepartureBeforeNowFilter.
 * @author mrGreenNV
 */
class FlightsWithoutDepartureBeforeNowFilterTest {
    private List<Flight> testFlights;
    private Flight correctFlight;
    private Flight incorrectFlight;

    /**
     * Initialize items.
     */
    @BeforeEach
    public void setUp() {
        testFlights = new ArrayList<>(2);

        correctFlight = createFlightWithCorrectSegments();
        testFlights.add(correctFlight);

        incorrectFlight = createFlightWithIncorrectSegments();
        testFlights.add(incorrectFlight);
    }

    /**
     * Checks filtering with a FlightsWithoutDepartureBeforeNowFilter strategy.
     */
    @Test
    public void testFilter() {
        FilterStrategy filterStrategy = new FlightsWithoutDepartureBeforeNowFilter();
        List<Flight> filteredFlight = filterStrategy.filter(testFlights);
        assertEquals(1, filteredFlight.size());
        assertFalse(filteredFlight.contains(incorrectFlight));
        assertTrue(filteredFlight.contains(correctFlight));
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
        return new Flight(List.of(new Segment(time.minusHours(2), time.plusHours(2))));
    }
}