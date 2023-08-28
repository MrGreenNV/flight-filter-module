package com.gridnine.testing;

/**
 * An exception thrown in case of an error when set time spent on earth.
 * @author mrGreenNV
 */
public class TimeSpentOnEarthException extends RuntimeException {

    /**
     * Allows you to create an exception with an error message.
     * @param msg error message.
     */
    public TimeSpentOnEarthException(String msg) {
        super(msg);
    }
}
