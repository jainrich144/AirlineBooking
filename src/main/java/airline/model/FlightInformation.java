package airline.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashMap;

/**
 * Created by Keyuri on 30-08-2017.
 * upgraded by RichaJain on 01/09/17.
 */

public class FlightInformation {
    private String flightNo;
    private String sourceCityId;
    private String destinationCityId;
    public HashMap<TravelClass.TravelClassName, TravelClass> travelClassType;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departDate;

    public boolean checkSeatsByTravelClass(String travelClassName, int seatsNeeded){
        int availableSeats = 0;

        switch (travelClassName) {
            case "Economy":
                availableSeats = travelClassType.get(TravelClass.TravelClassName.Economy).getAvailableSeats();
                break;

            case "Business":
                availableSeats = travelClassType.get(TravelClass.TravelClassName.Business).getAvailableSeats();
                break;

            case "First":
                availableSeats = travelClassType.get(TravelClass.TravelClassName.First).getAvailableSeats();
                break;
        }

        if( availableSeats >= seatsNeeded)
            return true;
        else
            return false;
    }

    public double getBaseFareByTravelClass(String travelClassName){
        double baseFare= 0.0;

        switch (travelClassName) {
            case "Economy":
                baseFare = travelClassType.get(TravelClass.TravelClassName.Economy).getBaseFare();
                break;

            case "Business":
                baseFare = travelClassType.get(TravelClass.TravelClassName.Business).getBaseFare();
                break;

            case "First":
                baseFare = travelClassType.get(TravelClass.TravelClassName.First).getBaseFare();
                break;
        }

        return baseFare;
    }

    public HashMap<TravelClass.TravelClassName, TravelClass> getTravelClassType() {
        return travelClassType;
    }

    public void setTravelClassType(HashMap<TravelClass.TravelClassName, TravelClass> travelClassType) {
        this.travelClassType = travelClassType;
    }

    public FlightInformation(String iFlightNo, String inputSourceId, String inputDestinationId, LocalDate departDate, HashMap<TravelClass.TravelClassName, TravelClass> travelClassType) {
        flightNo = iFlightNo;
        sourceCityId = inputSourceId;
        destinationCityId = inputDestinationId;
        this.departDate= departDate;
        this.travelClassType = travelClassType;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public String getSourceCityId() {
        return sourceCityId;
    }

    public String getDestinationCityId() {
        return destinationCityId;
    }

    public LocalDate getDepartDate() {
        return departDate;
    }

}
