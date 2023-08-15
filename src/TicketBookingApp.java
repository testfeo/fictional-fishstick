import java.io.*;
import java.time.YearMonth;
import java.util.*;

public class TicketBookingApp {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //TestDB.loadDataFromDatabase();

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
        SystemManager.showDepartureCity(departureCityList);

        //enter the user's choice into targetDeparture
        int departureUserChoice = scan.nextInt();
        targetDeparture = departureCityList.get(departureUserChoice - 1);
        System.out.println("From: " + targetDeparture);
        System.out.println();


        //sorted array, with available destinations from chosen departure
        List<String> destinationList = TestDB.getDestinationByDeparture(targetDeparture);

        //show directions to the user
        SystemManager.showDestinationCity(destinationList);

        //enter the user's choice
        int destinationChoice = scan.nextInt();
        targetDestination = destinationList.get(destinationChoice - 1);
        System.out.println("To: " + targetDestination);
        System.out.println();


        //SELECT DATE
        System.out.println("SELECT DATE: \n " +
                "-enter month [1-12]-");

        //Get month number from user
        int monthNumber = scan.nextInt();

        //show calendar for user
        SystemManager.getCalendar(monthNumber);

        System.out.println();
        System.out.println("ENTER NUMBER OF DAY");

        //targetFlightDays
        int dayOfWeek = scan.nextInt();
        targetFlightDays = SystemManager.sortFlightDays(dayOfWeek);


        //routes that match the given parameters: from - to/ when
        List<Route> sortedRoutes;
        sortedRoutes = TestDB.findRoutes(targetDeparture,targetDestination,targetFlightDays);

        System.out.println(
                "-----------------------------  FLIGHT RESULTS -----------------------------");
        System.out.println("Flights From: " + targetDeparture + " to " + targetDestination);

        YearMonth yearMonth = YearMonth.of(2023, monthNumber);
        System.out.println(yearMonth.getMonth().toString() + " " + dayOfWeek + " 2023");
        System.out.println();

        //show all routs that match user choice
        SystemManager.showRequestedRoutes(sortedRoutes);

        //enter the user's choice of FLIGHT
        int flightChoice = scan.nextInt();
        Route selectedFlight = sortedRoutes.get(flightChoice - 1);















    } //end main
} //end class







