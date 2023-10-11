import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    static Scanner scan = new Scanner(System.in);


    public static int intInputValidation(int max) {
        int min = 1;
        int result = 0;

        while (result == 0) {
            int userInput;
            try {
                userInput = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scan.nextLine();
                continue;
            }

            //check range
            if (userInput >= min && userInput <= max) {
                result = userInput;
            } else {
                System.out.println("Invalid choice. Please enter numbers from " + min + " to " + max);
            }
        }

        return result;
    }


    public static int sortFlightDays(int dayOfWeek) {
        return dayOfWeek % 2 == 0 ? 2 : 1;
    }


    //user document ID
    public static String UserDocumentValidation() {
        int capacity = 30;
        String regex ="^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]+$";

        return StringValidation(regex,capacity);
    }


    // valid User name
    public static String UserFullNameValidation() {
        int capacity = 100;
        String regex = "^[A-Za-z]+(?:[ .-`]*[A-Za-z]+)*$";

        scan.nextLine();
        return StringValidation(regex,capacity);
    }


    static String StringValidation(String regex, int capacity) {
        String result = null;

        while (result == null) {
            String userInput = scan.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(userInput);

            if (matcher.matches() & userInput.length() < capacity) {
                result = userInput;
            } else {
                System.out.println("Too many characters or invalid input. Please try again");
            }
        }
        return result;
    }

    public static void sayHello() {
        System.out.println("select 3. all work. Hello!");
    }

    public static void choice(int a) {
        switch (a) {
            case 1:
                System.out.println("you select 1");
                break;
            case 2:
                System.out.println("you select 2");
                break;
            case 3:
                sayHello();
                break;
        }

    }
}






