package airline.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashMap;

public class ResultCriteria{
    private String flightNo;
    private String sourceCityId;
    private String destinationCityId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departDate;
    private String travelClassName;
    private int numSeats;
    private double baseFare;
    private double totalFare;

    public ResultCriteria(String flightNo , String sourceCityId , String destinationCityId , LocalDate departDate , String travelClassName , int numSeats , double fare) {
        this.flightNo = flightNo;
        this.sourceCityId = sourceCityId;
        this.destinationCityId = destinationCityId;
        this.departDate = departDate;
        this.travelClassName = travelClassName;
        this.numSeats = numSeats;
        this.baseFare = fare;
        this.totalFare = getTotalFare();
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

    public String getTravelClassName() {
        return travelClassName;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public double getTotalFare() {
        totalFare = baseFare * numSeats;

        return totalFare;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public int getnumSeats() {
        return numSeats;
    }

    public double getBaseFare() {
        return baseFare;
    }

  
}
