import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

public class TicketBookingApp {
    public static void main(String[] args) {

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

        //create all Routs
        Routs CI106 = new Routs("WizzAir", "Chisinau", "Iasi", 1, "06:00", "06:40", 25);

        // chisinue - rome
        Routs CR212 = new Routs("AirItaly", "Chisinau", "Rome", 2, "12:30", "15:00", 150);
        Routs CR216 = new Routs("WizzAir", "Chisinau", "Rome", 2, "16:00", "18:30", 37);
        Routs CR109 = new Routs("Flyone", "Chisinau", "Rome", 1, "09:00", "11:30", 95);
        Routs CR120 = new Routs("WizzAir", "Chisinau", "Rome", 1, "20:00", "22:30", 45);

        //berlin - london
        Routs BL118 = new Routs("BritishAirways", "Berlin", "London", 1, "18:50", "21:10", 230);
        Routs BL107 = new Routs("lufthansa", "Berlin", "London", 1, "07:00", "8:50", 240);
        Routs BL221 = new Routs("lufthansa", "Berlin", "London", 2, "21:45", "23:50", 250);

        //amsterdam - new york
        Routs AN212 = new Routs("United Airlines", "Amsterdam", "New York", 2, "12:30", "20:40", 1260);
        Routs AN201 = new Routs("Delta Airlines", "Amsterdam", "New York", 2, "01:00", "09:30", 990);
        Routs AN109 = new Routs("KLM Dutch", "Amsterdam", "New York", 1, "09:00", "17:30", 1000);
        Routs AN106 = new Routs("SWISS", "Amsterdam", "New York", 1, "06:00", "14:30", 890);

        //HashSet DB with Routs
        Set<Routs> routs = new HashSet<>();
        routs.add(CR120);
        routs.add(BL107);
        routs.add(CI106);
        routs.add(CR109);
        routs.add(BL118);
        routs.add(CR212);
        routs.add(CR216);
        routs.add(AN212);
        routs.add(AN109);
        routs.add(AN201);
        routs.add(AN106);

        Scanner scan = new Scanner(System.in);

        //create variables in which we will store the user's choice
        String targetDeparture;
        String targetDestination;
        int targetFlightDays;

        //HashMap for selection WHERE TRAVELLING FROM
        HashMap<Integer, String> departureCity = new HashMap<>();
        departureCity.put(1, "Rome");
        departureCity.put(2, "Vienna");
        departureCity.put(3, "Amsterdam");
        departureCity.put(4, "Bucharest");
        departureCity.put(5, "Chisinau");
        departureCity.put(6, "Prague");
        departureCity.put(7, "Iasi");
        departureCity.put(8, "London");
        departureCity.put(9, "Berlin");
        departureCity.put(10, "New York");


        System.out.println(
                "----------------------------- SEARCH FLIGHTS -----------------------------");
        System.out.println();


        // FROM
        System.out.println("WHERE ARE YOU TRAVELLING FROM? \n " +
                "-inter a number of departureCity-");
        System.out.println();
        System.out.println(
                "1.Rome           6.Prague\n" +
                        "2.Vienna         7.Iasi\n" +
                        "3.Amsterdam      8.London\n" +
                        "4.Bucharest      9.Berlin\n" +
                        "5.Chisinau      10.New York");
        System.out.println();


        // 1. with switch/case ///////////////////
        /*switch (departureChoice) {
            case 1:
                targetDeparture = "Rome";
                break;
            case 2:
                targetDeparture = "Vienna";
                break;
            case 3:
                targetDeparture = "Amsterdam";
                break;
            case 4:
                targetDeparture = "Bucharest";
                break;
            case 5:
                targetDeparture = "Chisinau";
                break;
            case 6:
                targetDeparture = "Prague";
                break;
            case 7:
                targetDeparture = "Iasi";
                break;
            case 8:
                targetDeparture = "London";
                break;
            case 9:
                targetDeparture = "Berlin";
                break;
            case 10:
                targetDeparture = "New York";
                break;
            default:
                targetDeparture = "Error";
                break;
        }*/
        int departureChoice = scan.nextInt();
        //enter the user's choice
        targetDeparture = departureCity.get(departureChoice);
        System.out.println("From: " + targetDeparture);
        System.out.println();


        //TO
        System.out.println("WHERE DO YOU WANT TO GO? \n " +
                "-inter a number of destinationCity-");
        System.out.println();

        //sorted array, with available destinations from chosen departure
        List<String> sortedDestinationRout = new ArrayList<>();
        //Set<String> sortedDestinationRout = new HashSet<>();

        //fill array and remove repeat
        sortedDestinationRout = routs.stream()
                .filter(rout -> rout.getDeparture().equals(targetDeparture))
                .map(Routs::getDestination)
                .distinct().collect(Collectors.toList());


        //show directions to the user
        for (int i = 0; i < sortedDestinationRout.size(); i++) {
            System.out.println(i + 1 + "." + sortedDestinationRout.get(i));
        }

        //enter the user's choice
        int destinationChoice = scan.nextInt();

        targetDestination = sortedDestinationRout.get(destinationChoice - 1);
        System.out.println("To: " + targetDestination);
        System.out.println();


        //SELECT DATE
        System.out.println("SELECT DATE: \n " +
                "-enter month [1-12]-");

        //Get month number from user (1-12)
        int monthNumber = scan.nextInt();

        // create calendar
        YearMonth yearMonth = YearMonth.of(2023, monthNumber);

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

        //targetFlightDays
        int dayOfWeek = scan.nextInt();
        if (dayOfWeek % 2 == 0) {
            targetFlightDays = 2;
        } else targetFlightDays = 1;


        ////FLIGHT RESULTS

        //routes that match the given parameters
        Set<Routs> sortedDepartureRout = new HashSet<>();

        sortedDepartureRout = routs.stream().filter(element -> element.getDeparture().equals(targetDeparture)
                        && element.getDestination().equals(targetDestination) && element.getFlight_days() == targetFlightDays)
                .collect(Collectors.toSet());


        System.out.println(
                "-----------------------------  FLIGHT RESULTS -----------------------------");
        //System.out.println();
        System.out.println("Flights From: " + targetDeparture + " to " + targetDestination);
        System.out.println(yearMonth.getMonth().toString() + " " + dayOfWeek + " 2023");
        System.out.println();


        // выводим 1 рейс на экран со всей инфой из Set<Routs> sortedDepartureRout = new HashSet<>()

        if (!sortedDepartureRout.isEmpty()) {
            for (Routs rout : sortedDepartureRout) {
                System.out.println(rout.showAllRoutInfo());
                System.out.println();
            }
        }
    }
}







