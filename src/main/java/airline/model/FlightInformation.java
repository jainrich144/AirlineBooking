package airline.model;

/**
 * Created by Keyuri on 30-08-2017.
 * upgraded by RichaJain on 01/09/17.
 */

public class FlightInformation {
    private String flightNo;
    private String sourceCityId;
    private String destinationCityId;
    private int totalFlightCapacity;
    public int availableSeats;
    public int bookedSeats= 0;

    public FlightInformation(String iFlightNo, String inputSourceId, String inputDestinationId, int flightCapacity) {
        flightNo = iFlightNo;
        sourceCityId = inputSourceId;
        destinationCityId = inputDestinationId;
        totalFlightCapacity = flightCapacity;
        availableSeats = flightCapacity;
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

    public boolean checkAvailability(int seatsNeeded) {
        return availableSeats >= seatsNeeded;
    }

    public int getTotalFlightCapacity() { return totalFlightCapacity; }

    public int calAvailableSeat(){
        availableSeats = totalFlightCapacity - bookedSeats;
        return availableSeats;
    }

    public Object fieldCaller(Object theObject, String fieldName) throws NoSuchFieldException {
        return theObject.getClass().getField(fieldName);
    }
}
