
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Random;

public class ConsoleUI {

    public static void showCalendar(YearMonth yearMonth ) {

        System.out.println(yearMonth.getMonth().toString() + " 2023");
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");

        LocalDate firstDay = yearMonth.atDay(1);
        int offset = firstDay.getDayOfWeek().getValue() % 7;

        for (int i = 0; i < offset; i++) {
            System.out.print("    ");
        }

        for (int i = 1; i <= yearMonth.lengthOfMonth(); i++) {
            LocalDate currentDate = yearMonth.atDay(i);
            String day = String.format("%2d", i);

            //format
            if (currentDate.equals(LocalDate.now())) {
                System.out.print("\033[1m" + day + "\033[0m");
            } else {
                System.out.print(day);
            }
            System.out.print(" ");

            if (currentDate.getDayOfWeek().getValue() == 7) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("ENTER NUMBER OF DAY");
    }


    public static void showRequestedRoutes(List<Route> sortedRoutes,int monthNumber, int dayOfWeek ) {

        YearMonth yearMonth = YearMonth.of(2023, monthNumber);
        System.out.println(yearMonth.getMonth().toString() + " " + dayOfWeek + " 2023");
        System.out.println();

        if (!sortedRoutes.isEmpty()) {
            int counter = 1;
            for (Route route : sortedRoutes) {
                System.out.println(counter + ". " + route.showAllRoutInfo());
                System.out.println();
                counter++;
            }
        } else System.out.println("Unfortunately, no flights were found for the selected date. Try other dates.");
    }

    public static void showDepartureCity (List<String> departureCity) {

        System.out.println("WHERE ARE YOU TRAVELLING FROM? \n " +
                "-inter a number of departureCity-");
        System.out.println();

        for (int i = 0; i < departureCity.size(); i++) {
            System.out.println((i + 1) + ". " + departureCity.get(i));
        }
        System.out.println();
    }

    public static void showDestinationCity (List<String> destinationList) {

        System.out.println("WHERE DO YOU WANT TO GO? \n " +
                "-inter a number of destinationCity-");
        System.out.println();

        for (int i = 0; i < destinationList.size(); i++) {
            System.out.println(i + 1 + "." + destinationList.get(i));
        }
    }

    public static void showSeatClass(String targetDestination, Route selectedFlight) {

        System.out.println("-YOUR TRIP TO " + targetDestination + "-");

        System.out.println(
                selectedFlight.getAirline() + ": " + selectedFlight.getDeparture() + "[" + selectedFlight.getDeparture_times() + "]  ->  " + selectedFlight.getDestination() +
                        "[" + selectedFlight.getArrivalTime() + "]");
        System.out.println();

        //FIRST
        System.out.println("1." + "FIRST CLASS \n " +
                "PRICE:" + (selectedFlight.getPrice() + 50) + " EUR");
        System.out.println();
        System.out.println("-private cabin and special in-flight service \n" +
                "-cancel at anytime without fees-\n" +
                "-checked baggage: 50 kg- \n" +
                "-lounge access included-\n");


        //business
        System.out.println("2." + "BUSINESS CLASS \n " +
                "PRICE:" + (selectedFlight.getPrice() + 30) + " EUR");
        System.out.println();
        System.out.println("-flexibility to make unlimited changes- \n" +
                "-cancel at anytime without fees-\n" +
                "-checked baggage: 40 kg- \n" +
                "-lounge access included-");
        System.out.println();


        //ECONOMY
        System.out.println("3." + "ECONOMY CLASS \n " +
                "PRICE:" + selectedFlight.getPrice() + " EUR");
        System.out.println();
        System.out.println("-free carry-on bag-");
        System.out.println();

        System.out.println("|enter a number of class|");
    }














}






