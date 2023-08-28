package com.gridnine.testing;

import java.util.List;

/**
 * A component of the flight filter. Allows filtering the transmitted list of flights according to a given strategy.
 * @author mrGreenNV
 */
public class FlightFilterImpl implements FlightFilter {

    /** Filtering strategy. */
    private FilterStrategy filterStrategy;

    /**
     * Allows to set a flight strategy.
     * @param filterStrategy set filter strategy.
     */
    public void setFlightStrategy(FilterStrategy filterStrategy) {
        this.filterStrategy = filterStrategy;
    }

    /**
     * Allows filtering.
     * @return filtered list of Flight object.
     */
    public List<Flight> executeFilter(List<Flight> flights) {
        if (this.filterStrategy == null) {
            throw new FlightFilterException("Filtering error. To filter flights, you need to specify a filtering strategy.");
        }
        return filterStrategy.filter(flights);
    }

}
