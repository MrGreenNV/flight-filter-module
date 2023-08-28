package com.gridnine.testing;

import java.util.List;

/**
 * The interface sets filtering for a specific strategy.
 * @author mrGreenNV
 */
public interface FilterStrategy {

    /**
     * Filters the list of flights.
     * @param flights list of Flight objects to filter.
     * @return filtered list of Flight object.
     */
    List<Flight> filter(List<Flight> flights);

}
