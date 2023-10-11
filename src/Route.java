import java.io.Serializable;
import java.util.Objects;

public class Route {

    private String airline;
    private String departure;
    private String destination;
    private int flight_days;
    private String departure_times;
    private String arrivalTime;
    private int price;
    private String routes_number;


    public Route() {
    }

    public Route(String airline, String departure, String destination, int flight_days, String departure_times, String arrivalTime, int price, String routes_number) {
        this.airline = airline;
        this.departure = departure;
        this.destination = destination;
        this.flight_days = flight_days;
        this.departure_times = departure_times;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.routes_number = routes_number;
    }


    //get
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
    public String getRoutes_number() {
        return routes_number;
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
    public void setRoutes_number(String routes_number) {
        this.routes_number = routes_number;
    }



    @Override
    public int hashCode() {
        return Objects.hash(getAirline(), getDeparture(), getDestination(), getFlight_days(), getDeparture_times(), getArrivalTime(), getPrice(), getRoutes_number());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return flight_days == route.flight_days && Objects.equals(airline, route.airline) && Objects.equals(departure, route.departure) && Objects.equals(destination, route.destination) && Objects.equals(departure_times, route.departure_times)  && Objects.equals(arrivalTime, route.arrivalTime);
    }


    public String showAllRoutInfo() {
        return airline + ": " + departure + "[" + departure_times + "]  ->  " + destination +
                "[" + arrivalTime + "]\n PRICE from:" + price + " EURO";
    }


    @Override
    public String toString() {
        return "Route{" +
                "airline='" + airline + '\'' +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", flight_days=" + flight_days +
                ", departure_times='" + departure_times + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", price=" + price +
                ", routes_number='" + routes_number + '\'' +
                '}';
    }
}
