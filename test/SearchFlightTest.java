import airline.model.FlightInformation;
import airline.services.SearchFlightService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * upgraded by RichaJain on 01/09/17.
 */
public class SearchFlightTest {
    @Test
    public void testFlightsForSourcetoDestionation(){
        SearchFlightService service = new SearchFlightService();
        List<FlightInformation> selectedFlights = service.searchFlights("DEL","BOM", 20);
        Assert.assertEquals(1,selectedFlights.size());

    }
    @Test
   public void testSameSourcetoSameDestination(){
        SearchFlightService service = new SearchFlightService();
        List<FlightInformation> selectedFlights = service.searchFlights("BOM","BOM", 0);
        Assert.assertEquals(0,selectedFlights.size());

    }
}
