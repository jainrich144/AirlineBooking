package airline.controller;

import airline.DataSource;
import airline.model.*;
import airline.model.SearchCriteria;
import airline.model.ResultCriteria;
import airline.services.SearchFlightService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Created by RichaJain on 8/8/17.
 * upgraded by RichaJain on 01/09/17.
 */
@Controller
@SpringBootApplication
public class FlightController {

    //@Autowired
    //private SearchFlightService searchFlightService;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public List<ResultCriteria> resultFlights;

    public static void main(String[] args) {
        SpringApplication.run(FlightController.class, args);
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchFlights(@ModelAttribute(value="SearchCriteria") SearchCriteria searchCriteria , Model model){

         /*  Check if all input parameters are valid

        LocalDate depDate= departureDate;
        List<FlightInformation> flights = new SearchFlightService().searchFlights(fromCityId, toCityId, numSeatsRequested, departureDate, traveClassSelected);
        model.addAttribute("flights", flights);
        return "flightList";*/
        System.out.println("-------------------------------------\nSearching for ...");
        System.out.println(" Source = " + searchCriteria.getFromCityId() + "\n Dest = " + searchCriteria.getToCityId());
        System.out.println(" Date = " + searchCriteria.getDepartureDate());
        System.out.println(" Class = " + searchCriteria.getTravelClassName());
        System.out.println(" Seats = " + searchCriteria.getSeatsNeeded());
        System.out.println("-------------------------------------");

        resultFlights = new SearchFlightService().searchFlights(searchCriteria);

        for(ResultCriteria r : resultFlights) {
            System.out.println("Result " + r.getFlightNo() + " Seats : " + r.getnumSeats() + " Fare : " + r.getBaseFare());
        }

      //  model.addAttribute("resultFlights", resultFlights);
        //model.addAttribute("travelClassName", searchCriteria.getTravelClassName());
       // model.addAttribute("seatsNeeded", searchCriteria.getSeatsNeeded());

        model.addAttribute("resultFlights", resultFlights);

        return "FlightList";
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getLocations(Model model) {
        //@DateTimeFormat(pattern = "yyyy-MM-dd")
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String departureDate = formatter.format(today);
        System.out.println(departureDate);
        model.addAttribute("departureDate", departureDate);
        model.addAttribute("cityList", DataSource.getLocations());
        model.addAttribute("SearchCriteria", new SearchCriteria());
        return "flightSearch";
    }
}
