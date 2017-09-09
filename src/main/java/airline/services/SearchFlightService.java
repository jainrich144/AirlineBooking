package airline.services;

import airline.DataSource;
import airline.model.FlightInformation;
import airline.model.ResultCriteria;
import airline.model.SearchCriteria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by R on 30-08-2017.
 * upgraded by RichaJain on 01/09/17.
 */
@Service
public class SearchFlightService {
    DataSource flightList = new DataSource();
    List<FlightInformation> flight1 = new ArrayList<FlightInformation>();
    List<ResultCriteria> resultFlightList= new ArrayList<>();

    public List<ResultCriteria> searchFlights(SearchCriteria searchCriteria) {
 // String fromCityId , String toCityId , int numSeatsRequested , LocalDate departureDate, int traveClassSelected

        flight1 = flightList.getAllFlights();
        List<FlightInformation> filteredFlights= flight1.stream()
                .filter(x -> x.getSourceCityId().equals(searchCriteria.getFromCityId()))
                .filter(x -> x.getDestinationCityId().equals(searchCriteria.getToCityId()))
                .filter(x -> x.getDepartDate().equals(searchCriteria.getDepartureDate()))
                .filter(x -> x.checkSeatsByTravelClass(searchCriteria.getTravelClassName(), searchCriteria.getSeatsNeeded()))
                .collect(Collectors.toList());

        for(FlightInformation fl: filteredFlights){
            double fare = fl.getBaseFareByTravelClass(searchCriteria.getTravelClassName());
            ResultCriteria resultFlight = new ResultCriteria(fl.getFlightNo(),fl.getSourceCityId(),fl.getDestinationCityId(),fl.getDepartDate(),searchCriteria.getTravelClassName(),searchCriteria.getSeatsNeeded(),fare);
            resultFlightList.add(resultFlight);
        }

        return resultFlightList;
    }
}
