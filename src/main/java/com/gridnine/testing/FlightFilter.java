package com.gridnine.testing;

import java.util.List;

/**
 * The interface describes the functionality of the flight filter.
 * @author mrGreenNV
 */
public interface FlightFilter {

    /**
     * Starts filtering flights.
     * @param flights the original list of flights.
     * @return the filtered list of flights.
     */
    List<Flight> executeFilter(List<Flight> flights);

}
