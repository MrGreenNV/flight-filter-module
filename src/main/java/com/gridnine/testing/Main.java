package com.gridnine.testing;

import java.util.List;

/**
 * The class demonstrates the functionality of the filter.
 * @author mrGreenNV.
 */
public class Main {
    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();

        FlightFilterImpl filter = new FlightFilterImpl();

        try {

            System.out.println("The original list of flights:");
            System.out.println(flights);
            System.out.println();

            filter.setFlightStrategy(new FlightsWithoutDepartureBeforeNowFilter());
            System.out.println("List of flights without flights with departure time up to the current moment:");
            System.out.println(filter.executeFilter(flights));
            System.out.println();

            filter.setFlightStrategy(new FlightsWithoutArrivalBeforeDepartureFilter());
            System.out.println("List of flights without flights with arrival date earlier than departure date:");
            System.out.println(filter.executeFilter(flights));
            System.out.println();

            filter.setFlightStrategy(new FlightsWithoutLongGroundTimeFilter());
            System.out.println("List of flights without flights with a waiting time on the ground of more than two hours:");
            System.out.println(filter.executeFilter(flights));
            System.out.println();

            filter.setFlightStrategy(null);
            filter.executeFilter(flights);

        } catch (FlightFilterException ffEx) {
            System.out.println("Checking for throwing an exception with an unspecified strategy.");
            System.out.println(ffEx.getMessage());
            System.out.println();
        }

        try {
            filter.setFlightStrategy(new FlightsWithoutLongGroundTimeFilter(-2));
        } catch (TimeSpentOnEarthException tseEx) {
            System.out.println("Checking for throwing an exception when specifying an incorrect waiting time on the ground.");
            System.out.println(tseEx.getMessage());
            System.out.println();
        }

    }
}