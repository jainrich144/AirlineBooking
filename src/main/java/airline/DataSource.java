package airline;

import airline.model.FlightInformation;
import airline.model.Location;
import airline.model.Plane;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/**
 * Created by Keyuri on 31-08-
 * upgraded by RichaJain on 01/09/17.
 */
public class DataSource {

    public static List<Location> locationList;
    public static List<FlightInformation> flightList;
   // public static List<Plane> planeList;

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

    public static List<FlightInformation> getAllFlights() {

        List<FlightInformation> flightList = new ArrayList<FlightInformation>();
        /*String csvFile = "/main/resources/flightsDB.csv";

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
                flightList.add(new FlightInformation(line[0],line[1],line[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
*/


        flightList.add(new FlightInformation("AI0010", "DEL", "BOM", 20));
        flightList.add(new FlightInformation("BA1123", "HYD", "PUN",10));
        flightList.add(new FlightInformation("AI0030", "HYD", "BLR",5));
        flightList.add(new FlightInformation("AI0031", "HYD", "BOM",8));
        flightList.add(new FlightInformation("AI0032", "HYD", "DEL",10));
        flightList.add(new FlightInformation("AI0040", "BLR", "HYD", 10));
        flightList.add(new FlightInformation("AI0042", "BLR", "PUN",50));
        flightList.add(new FlightInformation("AI0045", "BLR", "DEL",80));
        flightList.add(new FlightInformation("AI0046", "BLR", "BOM",12));
        flightList.add(new FlightInformation("AI0050", "PUN", "BOM",4));
        flightList.add(new FlightInformation("AI0052", "PUN", "BLR",6));
        flightList.add(new FlightInformation("AI0060", "DEL", "BOM",5));
        return flightList;
    }

}
