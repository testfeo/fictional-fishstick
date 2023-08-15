
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

public class SystemManager {

    public static void getCalendar(int monthNumber) {
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
    }

    public static int sortFlightDays(int dayOfWeek) {
        int targetFlightDays;
        return dayOfWeek % 2 == 0 ? 2 : 1;
    }


    public static void showRequestedRoutes(List<Route> sortedRoutes) {
        if (!sortedRoutes.isEmpty()) {
            int counter = 1;
            for (Route route : sortedRoutes) {
                System.out.println(counter + ". " + route.showAllRoutInfo());
                System.out.println();
                counter++;
            }
        }
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
}




