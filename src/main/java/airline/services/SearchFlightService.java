package airline.services;

import airline.DataSource;
import airline.model.FlightInformation;
import airline.model.Location;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by R on 30-08-2017.
 * upgraded by RichaJain on 01/09/17.
 */
public class SearchFlightService {



    public static List<FlightInformation> filterFlights(List<FlightInformation> flights, String filterType, String fliterValue) {

        List<FlightInformation> selectedFlights = new ArrayList<FlightInformation>();
        for(FlightInformation flight : flights) {


            if ((filterType.equalsIgnoreCase("sourceCityId")) &&  fliterValue.equalsIgnoreCase(flight.getSourceCityId()) ||
                    (filterType.equalsIgnoreCase("destinationCityId")) &&  fliterValue.equalsIgnoreCase(flight.getDestinationCityId()) ||
                      (filterType.equalsIgnoreCase("availableSeats")) &&  flight.checkAvailability(Integer.parseInt(fliterValue))
                    ){
                selectedFlights.add(flight);
            }
        }
        return selectedFlights;
    }

    public List<FlightInformation> searchFlights(String sourceCityId, String destinationCityId, int requestedSeats) {
        List<FlightInformation> filteredFlights = DataSource.getAllFlights();


        // 1
        filteredFlights = filterFlights(filteredFlights, "sourceCityId", sourceCityId);
        System.out.println("SRC " + filteredFlights.size());
        if (filteredFlights.size() < 1) return filteredFlights; // Return Null

        // 2
        filteredFlights = filterFlights(filteredFlights, "destinationCityId", destinationCityId);
        System.out.println("DEST " + filteredFlights.size());
        if (filteredFlights.size() < 1) return filteredFlights;

        // 3
        filteredFlights = filterFlights(filteredFlights, "availableSeats", Integer.toString(requestedSeats));
        System.out.println("AVAIL " + filteredFlights.size());
        if (filteredFlights.size() < 1) return filteredFlights;

        return filteredFlights;
    }
}
