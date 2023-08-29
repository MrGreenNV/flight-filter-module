package com.gridnine.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for FlightFilterImpl.
 * @author mrGreenNV
 */
class FlightFilterImplTest {

    private List<Flight> testFlights;

    /**
     * Initialize items.
     */
    @BeforeEach
    public void setUp() {
        testFlights = new ArrayList<>(2);
    }

    /**
     * Checks for throwing an FlightFilterException.
     */
    @Test
    public void testExecuteFilter_throwFlightFilterException() {

        FlightFilterImpl filter = new FlightFilterImpl();

        RuntimeException exception = assertThrows(FlightFilterException.class, () -> filter.executeFilter(testFlights));

        assertEquals(FlightFilterException.class, exception.getClass());
        assertEquals("Filtering error. To filter flights, you need to specify a filtering strategy.", exception.getMessage());
    }
}