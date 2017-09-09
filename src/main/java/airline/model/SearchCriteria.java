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
    public String getTravelClassName() {
        return travelClassName;
    }

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
