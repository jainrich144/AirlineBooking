package airline.services;

import airline.DataSource;
import airline.model.FlightInformation;
import airline.model.ResultCriteria;
import airline.model.SearchCriteria;
import airline.model.TravelFare;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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

    public boolean getFlightsForDepartDate(FlightInformation flightInfo, LocalDate depDate){
        if (depDate == null){
            Date today = new Date();
            LocalDate ldtoday = new java.sql.Date(today.getTime()).toLocalDate();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String departureDate = formatter.format(today);
            System.out.println(departureDate);
            return flightInfo.getDepartDate().isAfter(ldtoday);
        }
        else {
            return flightInfo.getDepartDate().equals(depDate);
        }
    }

    public List<ResultCriteria> searchFlights(SearchCriteria searchCriteria) {
 // String fromCityId , String toCityId , int numSeatsRequested , LocalDate departureDate, int traveClassSelected

        flight1 = flightList.getAllFlights();
        List<FlightInformation> filteredFlights= flight1.stream()
                .filter(x -> x.getSourceCityId().equals(searchCriteria.getFromCityId()))
                .filter(x -> x.getDestinationCityId().equals(searchCriteria.getToCityId()))
                .filter(x -> getFlightsForDepartDate(x, searchCriteria.getDepartureDate()))
                .filter(x -> x.checkSeatsByTravelClass(searchCriteria.getTravelClassName(), searchCriteria.getSeatsNeeded()))
                .collect(Collectors.toList());

        for(FlightInformation fl: filteredFlights){
            double fare = fl.getBaseFareByTravelClass(searchCriteria.getTravelClassName());
            TravelFare trFare = new TravelFare(fl.getDepartDate(),searchCriteria.getTravelClassName(),searchCriteria.getSeatsNeeded(),fare);
            ResultCriteria resultFlight = new ResultCriteria(fl.getFlightNo(),fl.getSourceCityId(),fl.getDestinationCityId(),fl.getDepartDate(),searchCriteria.getTravelClassName(),searchCriteria.getSeatsNeeded(),fare);
            resultFlightList.add(resultFlight);
        }

        return resultFlightList;
    }
}
