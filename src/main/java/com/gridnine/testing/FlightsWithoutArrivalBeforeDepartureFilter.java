package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The class is a filtering strategy that excludes flights with arrival date up to the departure date.
 * @author mrGreenNV
 */
public class FlightsWithoutArrivalBeforeDepartureFilter implements FilterStrategy {

    /**
     * Filters the list of flights, excluding flights with arrival date up to the departure date.
     * @param flights list of Flight objects to filter.
     * @return filtered list of Flight object.
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
