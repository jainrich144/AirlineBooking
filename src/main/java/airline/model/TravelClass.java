package airline.model;

public class TravelClass {
    public enum TravelClassName{
        Economy,
        Business,
        First
    };

    private int totalSeats;
    private int bookedSeats;
    private double baseFare;

    public TravelClass(int totalSeats , int bookedSeats, double baseFare) {
        this.totalSeats = totalSeats;
        this.bookedSeats = bookedSeats;
        this.baseFare = baseFare;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public int getAvailableSeats() {
        return totalSeats - bookedSeats;
    }

    public double getBaseFare() {
        return baseFare;
    }

}
