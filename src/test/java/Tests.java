import com.gridnine.testing.builder.FlightBuilder;
import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.service.FlightFilterBuilderImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class  Tests {
    @Test
    public void shouldJUnitTestTest_buildAllFlightsWithoutFilters  () {
        List<Flight> flights = FlightBuilder.createFlights();
        List<Flight> flights_= new FlightFilterBuilderImpl(flights)
                .build();
        List<Flight > actual = new ArrayList<>(flights );
        assertEquals(6, actual.size());
    }

    @Test
    public void shouldJUnitTest_filterDepartBeforeNow() {
        List<Flight> flights = FlightBuilder.createFlights();
        List<Flight> flightsDepartBeforeNow = new FlightFilterBuilderImpl (flights)
                .filterDepartBeforeNow()
                .build();
        List<Flight > actual = new ArrayList<>(flightsDepartBeforeNow);
        assertEquals(5, actual.size());
    }
    @Test
    public void shouldJUnitTestTest_filterArrivalFirstBeforeDeparture() {
        List<Flight> flights = FlightBuilder.createFlights();
        List<Flight> flightsArrivalFirstBeforeDeparture = new FlightFilterBuilderImpl (flights)
                .filterArrivalFirstBeforeDeparture()
                .build();
        List<Flight > actual = new ArrayList<>(flightsArrivalFirstBeforeDeparture );
        assertEquals(5, actual.size());
    }

    @Test
    public void shouldJUnitTestTest_filterSomeTimeSpentOnTheGroundForMoreThanTwoHours() {
        List<Flight> flights = FlightBuilder .createFlights();
        List<Flight> filterSomeTimeSpentOnTheGroundForMoreThanTwoHours = new FlightFilterBuilderImpl (flights)
                .filterSomeTimeSpentOnTheGroundForMoreThanTwoHours()
                .build();
        List<Flight > actual = new ArrayList<>(filterSomeTimeSpentOnTheGroundForMoreThanTwoHours);
        assertEquals(4, actual.size());
    }
}
