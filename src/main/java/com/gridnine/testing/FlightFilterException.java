package com.gridnine.testing;

/**
 * An exception thrown in case of an error when filtering flights.
 * @author mrGreenNV
 */
public class FlightFilterException extends RuntimeException {

    /**
     * Allows you to create an exception with an error message.
     * @param msg error message.
     */
    public FlightFilterException(String msg) {
        super(msg);
    }
}
