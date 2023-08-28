package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Bean that represents a flight.
 * Represents a flight consisting of multiple segments.
 * @author Gridnine Systems.
 */
class Flight {

    /** List of Segment object. */
    private final List<Segment> segments;

    /**
     * Constructs a new Flight the specified segments.
     * @param segs list of Segment object.
     */
    Flight(final List<Segment> segs) {
        segments = segs;
    }

    /**
     * Get the list of Segment object for this flight.
     * @return The list of Segment object.
     */
    List<Segment> getSegments() {
        return segments;
    }

    /**
     * Returns a string representation of the flight.
     * @return A string containing a representation of all segments in the flight.
     */
    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}
