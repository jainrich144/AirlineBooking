package airline.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class SearchCriteria{




    private String fromCityId;
    private String toCityId;
    private int seatsNeeded;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureDate;

    private String travelClassName;
    public SearchCriteria(){}
    public SearchCriteria(String fromCityId , String toCityId) {
        this.fromCityId = fromCityId;
        this.toCityId = toCityId;
    }

    public SearchCriteria(String fromCityId , String toCityId , int seatsNeeded) {
        this.fromCityId = fromCityId;
        this.toCityId = toCityId;
        this.seatsNeeded = seatsNeeded;
    }

    public SearchCriteria(String fromCityId , String toCityId , int seatsNeeded , LocalDate departureDate) {
        this.fromCityId = fromCityId;
        this.toCityId = toCityId;
        this.seatsNeeded = seatsNeeded;
        this.departureDate = departureDate;
    }

    public SearchCriteria(String fromCityId , String toCityId , int seatsNeeded , LocalDate departureDate , String travelClassName) {
        this.fromCityId = fromCityId;
        this.toCityId = toCityId;
        this.seatsNeeded = seatsNeeded;
        this.departureDate = departureDate;
        this.travelClassName = travelClassName;
    }

    public SearchCriteria(String fromCityId , String toCityId , int seatsNeeded , String travelClassName) {
        this.fromCityId = fromCityId;
        this.toCityId = toCityId;
        this.seatsNeeded = seatsNeeded;
        this.travelClassName = travelClassName;
    }

    public String getTravelClassName() { return travelClassName; }



    public void setTravelClassName(String travelClassName) {
        this.travelClassName = travelClassName;
    }

    public String getFromCityId() {
        return fromCityId;
    }

    public void setFromCityId(String fromCityId) {
        this.fromCityId = fromCityId;
    }

    public String getToCityId() {
        return toCityId;
    }

    public void setToCityId(String toCityId) {
        this.toCityId = toCityId;
    }

    public int getSeatsNeeded() {
        return seatsNeeded;
    }

    public void setSeatsNeeded(int seatsNeeded) {
        this.seatsNeeded = seatsNeeded;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

}
