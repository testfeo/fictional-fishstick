import java.time.Month;

public class Ticket {
    private Month departureMonth;
    private int dayOfMonth;
    private String departure_times;
    private String arrivalTime;
    private int price;
    private String airline;
    private String departure;
    private String destination;
    private User user;
    private Seat seat;
    private int baggage;


    public Ticket() {
    }

    public Ticket(String departure, String destination, Month departureMonth, int dayOfMonth, String departure_times, String arrivalTime,
                  String airline, int price,  User user, Seat seat, int baggage) {
        this.departureMonth = departureMonth;
        this.departure_times = departure_times;
        this.dayOfMonth = dayOfMonth;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.airline = airline;
        this.departure = departure;
        this.destination = destination;
        this.user = user;
        this.seat = seat;
        this.baggage = baggage;
    }

    public Month getDepartureMonth() {
        return departureMonth;
    }

    public void setDepartureMonth(Month departureMonth) {
        this.departureMonth = departureMonth;
    }

    public String getDeparture_times() {
        return departure_times;
    }

    public void setDeparture_times(String departure_times) {
        this.departure_times = departure_times;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public int getBaggage() {
        return baggage;
    }

    public void setBaggage(int baggage) {
        this.baggage = baggage;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }


    public void printTicket() {
        System.out.println();

        System.out.println("************ Airline Ticket ****************");
        System.out.println("Operated by " + airline.toUpperCase() + "\n");

        System.out.println("Name of passenger: " + user.getName().toUpperCase() + "\n");

        System.out.println(departure.toUpperCase() + "->" + destination.toUpperCase());
        System.out.println(departure_times + "  " + dayOfMonth + " " + departureMonth);
        System.out.println("Seat:" + seat.seatNumber + "  Baggage: " + baggage + "kg");
        System.out.println("*********************************************");


    }







}
