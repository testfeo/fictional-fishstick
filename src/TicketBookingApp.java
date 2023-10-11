import java.io.*;
import java.time.YearMonth;
import java.util.*;

public class TicketBookingApp {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


       /* for (;;) {
            System.out.println("");
            System.out.println(
                    "####################################### Welcome to the flight ticket purchase system! ########################################");
            System.out.println();
            System.out.println(
                    "------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(
                    "-------------------------------------------------- 1. Search For A flight -------------------------------------------------------");
            System.out.println(
                    "-------------------------------------------------- 2. Cancel A Ticket -------------------------------------------------------------");
            System.out.println(
                    "-------------------------------------------------- 3. Edit A Flight  ---------------------------------------------------------");
            System.out.println(
                    "-------------------------------------------------- 4. Print A Ticket ----------------------------------------------------------");

            System.out.print("Please select the serial number to be operated:");
*/

////////////////////////////////// Search For A flight //////////////////////////////////////////

        Scanner scan = new Scanner(System.in);

        //create variables in which we will store the user's choice
        String targetDeparture;
        String targetDestination;
        int targetFlightDays;

        // List for selection WHERE TRAVELLING FROM
        List<String> departureCityList = TestDB.loadDepartureFromDatabase();


        System.out.println(
                "----------------------------- SEARCH FLIGHTS -----------------------------");
        System.out.println();


        //show the user options for where to fly from
        ConsoleUI.showDepartureCity(departureCityList);

        //enter the user's choice into targetDeparture
        int departureUserChoice = Validation.intInputValidation(departureCityList.size());
        targetDeparture = departureCityList.get(departureUserChoice - 1);
        System.out.println("From: " + targetDeparture);
        System.out.println();


        //sorted array, with available destinations from chosen departure
        List<String> destinationList = TestDB.findDestinationByDeparture(targetDeparture);

        //show directions to the user
        ConsoleUI.showDestinationCity(destinationList);

        //enter the user's choice
        int destinationChoice = Validation.intInputValidation(destinationList.size());
        targetDestination = destinationList.get(destinationChoice - 1);
        System.out.println("To: " + targetDestination);
        System.out.println();

        //SELECT DATE
        System.out.println("SELECT DATE: \n " +
                "-enter month [1-12]-");

        //Get month number from user
        int monthNumber = Validation.intInputValidation(12);
        YearMonth yearMonth = YearMonth.of(2023, monthNumber);

        //show calendar for user
        ConsoleUI.showCalendar(yearMonth);

        //targetFlightDays
        int dayOfWeek = Validation.intInputValidation(31);
        targetFlightDays = Validation.sortFlightDays(dayOfWeek);

        //routes that match the given parameters: from - to/ when
        List<Route> sortedRoutes = TestDB.findRoutes(targetDeparture, targetDestination, targetFlightDays);

        System.out.println(
                "-----------------------------  FLIGHT RESULTS -----------------------------");
        System.out.println("Flights From: " + targetDeparture + " to " + targetDestination);
        //show all routs that match user choice
        ConsoleUI.showRequestedRoutes(sortedRoutes, monthNumber, dayOfWeek);

        //enter the user's choice of FLIGHT
        int flightChoice = Validation.intInputValidation(sortedRoutes.size());
        Route selectedFlight = sortedRoutes.get(flightChoice - 1);

        //show seats classes and get it
        ConsoleUI.showSeatClass(targetDestination, selectedFlight);
        SeatClass seatClass = Seat.getSeatClass();

        //add random seat number
        Seat seatNumber = new Seat(Seat.generateRandomSeat(seatClass));

        // ask user about Baggage
        int baggage = Baggage.getBaggage(seatClass);

        //get user Information
        User user =  User.getUserInformation();

        //create ticket with all information
        Ticket ticket = new Ticket(selectedFlight.getDeparture(),selectedFlight.getDestination(),
                                    yearMonth.getMonth(),dayOfWeek, selectedFlight.getDeparture_times(),
                                    selectedFlight.getArrivalTime(), selectedFlight.getAirline(),
                                    selectedFlight.getPrice(), user, seatNumber, baggage);

        //print ticket with all information
        ticket.printTicket();




    }
}