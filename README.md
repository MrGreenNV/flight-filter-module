# Flight Filtering Module

This is a small Java module designed for filtering flights based on various rules. A flight represents the transportation of a passenger from one point to another with possible intermediate stops. A flight can be represented as a set of one or more elementary movements called segments. A segment is an atomic transportation characterized by two attributes: departure date/time and arrival date/time.
## Task Description

The task was to implement a module that filters a set of flights according to different rules. Filtering rules can be diverse and can be dynamically chosen based on the context of the filtering operation.

The code structure is designed to accommodate various filtering strategies. No user interface is required; the results are displayed in the console. External libraries are not needed for this implementation.
## Implementation Approach

1. **FilterStrategy Interface:** The `FilterStrategy` interface defines the contract for different filtering strategies. Implementation of the `filter` method is required, which takes a list of flights and returns a filtered list.

2. **FlightsWithoutDepartureBeforeNowFilter:** This class implements a filtering strategy that excludes flights with a departure date up to the current time.

3. **FlightsWithoutArrivalBeforeDepartureFilter:** This class implements a filtering strategy that excludes flights with arrival dates before their departure dates.

4. **FlightsWithoutLongGroundTimeFilter:** This class implements a filtering strategy that excludes flights with segments where the ground time (time spent on the ground) between arrival and departure exceeds a preset limit.

5. **FlightFilter Interface:** The `FlightFilter`  interface defines the contract for a filter. Implementation of the `executeFilter` method is required, which takes a list of flights and returns a filtered list.

6. **FlightFilterImpl:** This class implements the filter with the selected filtering strategy.

7. **Main Class:** You can use the `Main` class to test filtering strategies on sample test data. Just add instances of filtering strategies and observe the results in the console.

## Running the Code

1. Clone this repository to your local machine.

2. Open your preferred Java development environment (e.g., IntelliJ IDEA, Eclipse).

3. Create a new Java project and import the cloned repository.

4. Run the `Main` class to see the results of applying filtering strategies to sample test data in the console.

## Testing

Unit tests for filtering strategies can be found in the test package. You can run the tests using testing frameworks like JUnit.
