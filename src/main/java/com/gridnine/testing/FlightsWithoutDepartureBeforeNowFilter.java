package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The class is a filtering strategy that excludes flights with a departure date up to the current time.
 * @author mrGreenNV
 */
public class FlightsWithoutDepartureBeforeNowFilter implements FilterStrategy {

    /**
     * Filters the list of flights, excluding flights with departure date up to the current time.
     * @param flights list of Flight objects to filter.
     * @return filtered list of Flight object.
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        LocalDateTime now = LocalDateTime.now();
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate().isAfter(now)))
                .collect(Collectors.toList());
    }
}
