import java.util.Objects;

public class Routs {

    private String airline;
    private String departure;
    private String destination;
    private int flight_days;
    private String departure_times;
    private String arrivalTime;
    private int price;


    public Routs(String airline, String departure, String destination, int flight_days, String departure_times, String arrivalTime, int price) {
        this.airline = airline;
        this.departure = departure;
        this.destination = destination;
        this.flight_days = flight_days;
        this.departure_times = departure_times;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAirline(), getDeparture(), getDestination(), getFlight_days(), getDeparture_times(), getArrivalTime(), getPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Routs routs = (Routs) o;
        return flight_days == routs.flight_days && Objects.equals(airline, routs.airline) && Objects.equals(departure, routs.departure) && Objects.equals(destination, routs.destination) && Objects.equals(departure_times, routs.departure_times)  && Objects.equals(arrivalTime, routs.arrivalTime);
    }

    // get
    public String getAirline() {
        return airline;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public int getFlight_days() {
        return flight_days;
    }

    public String getDeparture_times() {
        return departure_times;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public int getPrice() {
        return price;
    }


    //set
    public void setAirline(String airline) {
        this.airline = airline;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setFlight_days(int flight_days) {
        this.flight_days = flight_days;
    }

    public void setDeparture_times(String departure_times) {
        this.departure_times = departure_times;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setPrice(int price) {
        this.price = price;
    }




    public String showAllRoutInfo() {
        return airline + ": " + departure + "[" + departure_times + "]  ->  " + destination +
                "[" + arrivalTime + "]\n PRICE:" + price + " EURO";
    }


    @Override
    public String toString() {
        return "Routs{" +
                "airline='" + airline + '\'' +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", flight_days=" + flight_days +
                ", departure_times='" + departure_times + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                '}';
    }


}
