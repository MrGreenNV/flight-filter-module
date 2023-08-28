package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class implements a filter strategy for excluding flights with long ground time.
 * @author mrGreenNV
 */
public class FlightsWithoutLongGroundTime implements FilterStrategy {

    /** Preset time spent on earth */
    private int groundTimeHours = 2;

    /**
     * Set the maximum allowed time spent on earth.
     * @param groundTimeHours The maximum allowed time spent on earth (in hours).
     * @throws TimeSpentOnEarthException If the provided ground time is negative.
     */
    public void setGroundTimeHours(int groundTimeHours) {
        if (groundTimeHours < 0) {
            throw new TimeSpentOnEarthException("The time spent on earth cannot be negative");
        }
        this.groundTimeHours = groundTimeHours;
    }

    /**
     * Filters a list of flights to exclude those with ground time exceeding the preset limit.
     * @param flights The list of flights to be filtered.
     * @return A new list containing flights with ground time within the preset limit.
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> {
                    List<Segment> segments = flight.getSegments();
                    for (int i = 0; i < segments.size() - 1; i++) {
                        LocalDateTime nextDeparture = segments.get(i + 1).getDepartureDate();
                        LocalDateTime currentArrival = segments.get(i).getArrivalDate();
                        if (nextDeparture.minusHours(groundTimeHours).isAfter(currentArrival)) {
                            return false;
                        }
                    }
                    return true;
                })
                .collect(Collectors.toList());
    }
}
