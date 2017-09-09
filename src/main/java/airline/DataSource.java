package airline;

import airline.model.FlightInformation;
import airline.model.Location;
import airline.model.TravelClass;

import java.time.LocalDate;
import java.util.*;

/**
 * Created by Keyuri on 31-08-
 * upgraded by RichaJain on 01/09/17.
 */
public class DataSource {

    public static List<Location> locationList;
    public static List<FlightInformation> flightSchedulerList;

    public static List<Location> getLocations() {

        List<Location> locationList = new ArrayList<Location>();
        try {
            Properties locations = new Properties();
            locations.load(DataSource.class.getResourceAsStream("/locations.properties"));
            Enumeration enumeration = locations.keys();
            while (enumeration.hasMoreElements()) {
                String locationId = (String) enumeration.nextElement();
                locationList.add(new Location(locationId, locations.getProperty(locationId)));

            }
        } catch (java.io.IOException e) {

        }

        return locationList;
    }

    public List<FlightInformation> getAllFlights() {
        List<FlightInformation> flightList = new ArrayList<FlightInformation>();

        HashMap<TravelClass.TravelClassName, TravelClass> travelClass = new HashMap<>();
        travelClass.put(TravelClass.TravelClassName.Economy, new TravelClass(100, 95, 6000));
        travelClass.put(TravelClass.TravelClassName.Business , new TravelClass(40, 35, 8000));
        travelClass.put(TravelClass.TravelClassName.First, new TravelClass(10, 5, 10000));

        FlightInformation f1 = new FlightInformation("BA1123", "HYD", "PUN", LocalDate.of(2017,9,17), travelClass);
        flightList.add(f1);

        f1 = new FlightInformation("BA1124", "HYD", "MUM", LocalDate.of(2017,9,17), travelClass);
        flightList.add(f1);

        f1 = new FlightInformation("BA1125", "HYD", "PUN", LocalDate.of(2017,9,17), travelClass);
        flightList.add(f1);

        //trClass[TravelClass.TravelClassName.Economy]= new TravelClass(TravelClass.TravelClassName.Economy,20,10);

/*
        flightList.add(new FlightInformation("AI0030", "HYD", "BLR",5,LocalDate.of(2017,9,07)));
        flightList.add(new FlightInformation("AI0031", "HYD", "BOM",8,LocalDate.of(2017,9,07)));
        flightList.add(new FlightInformation("AI0032", "HYD", "DEL",10,LocalDate.of(2017,9,07)));
        flightList.add(new FlightInformation("AI0040", "BLR", "HYD", 10,LocalDate.of(2017,9,07)));
        flightList.add(new FlightInformation("AI0042", "BLR", "PUN",50,LocalDate.of(2017,9,07)));
        flightList.add(new FlightInformation("AI0045", "BLR", "DEL",80,LocalDate.of(2017,9,07)));
        flightList.add(new FlightInformation("AI0046", "BLR", "BOM",12,LocalDate.of(2017,9,07)));
        flightList.add(new FlightInformation("AI0050", "PUN", "BOM",4,LocalDate.of(2017,9,07)));
        flightList.add(new FlightInformation("AI0052", "PUN", "BLR",6,LocalDate.of(2017,9,07)));
        flightList.add(new FlightInformation("AI0060", "DEL", "BOM",5,LocalDate.of(2017,9,07)));
*/
        return flightList;
    }

}
