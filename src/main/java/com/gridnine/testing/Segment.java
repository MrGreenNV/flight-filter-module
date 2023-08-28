package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Bean that represents a flight segment.
 * This class represents a single segment of a flight, characterized by its departure and arrival dates.
 * Instances of this class are immutable once created.
 * @author Gridnine Systems.
 */
class Segment {

    /** Departure date */
    private final LocalDateTime departureDate;

    /** Arrival date */
    private final LocalDateTime arrivalDate;

    /**
     * Constructs a new Segment with the specified departure and arrival dates.
     * @param dep The departure date and time of the segment.
     * @param arr The arrival date and time of the segment.
     * @throws NullPointerException If either dep or arr is null.
     */
    Segment(final LocalDateTime dep, final LocalDateTime arr) {
        departureDate = Objects.requireNonNull(dep);
        arrivalDate = Objects.requireNonNull(arr);
    }

    /**
     * Get the departure date and time of the segment.
     * @return The departure date and time.
     */
    LocalDateTime getDepartureDate() {
        return departureDate;
    }

    /**
     * Get the arrival date and time of the segment.
     * @return The arrival date and time.
     */
    LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Returns a string representation of the segment.
     * The format of the string is "[departureDate|arrivalDate]" where departureDate and arrivalDate are
     * formatted as "yyyy-MM-dd'T'HH:mm".
     * @return The string representation of the segment.
     */
    @Override
    public String toString() {
        DateTimeFormatter fmt =
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return '[' + departureDate.format(fmt) + '|' + arrivalDate.format(fmt)
                + ']';
    }
}
