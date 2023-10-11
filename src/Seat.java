import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Seat {
    String seatNumber;

    public Seat() {
    }
    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public static SeatClass getSeatClass() {
        HashMap<Integer, SeatClass> seatClassMap = new HashMap<>();
        seatClassMap.put(1, SeatClass.FIRST);
        seatClassMap.put(2, SeatClass.BUSINESS);
        seatClassMap.put(3, SeatClass.ECONOMY);

        return seatClassMap.get(Validation.intInputValidation(seatClassMap.size()));
    }

    public static String generateRandomSeat(SeatClass seatClass) {
        Random random = new Random();
        char[] colLetters = {'A', 'B', 'C', 'D', 'E', 'F'};
        int min = 0;
        int max = 0;

        switch (seatClass) {
            case FIRST:
                min = 1;
                max = 4;
                break;
            case BUSINESS:
                min = 5;
                max = 12;
                break;
            case ECONOMY:
                min = 13;
                max = 30;
                break;
        }
        char randomRow = colLetters[random.nextInt(colLetters.length)]; //random letter
        int randomSeatNumber = random.nextInt(max - min + 1) + min; //random int from 1
        return String.valueOf(randomRow) + randomSeatNumber;
    }










}

