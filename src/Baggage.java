import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Baggage {

    //get amount of baggage by seat class
    public static int getBaggage(SeatClass seatClass) {
        int baggage = 0;

        switch (seatClass) {
            case ECONOMY:
                baggage = getEconomyClassBaggage();
                break;
            case BUSINESS:
                baggage = 40;
                break;
            case FIRST:
                baggage = 50;
                break;
        }
        return baggage;
    }

    //get amount of baggage by Economy class
    public static int getEconomyClassBaggage() {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,10);
        map.put(2,20);
        map.put(3,30);
        map.put(4,0);

        System.out.println("CHECKED-IN BAGGAGE \n" +
                "1. 10kg    2. 20kg    3. 30kg  4. I don't need additional baggage.");

        return map.get(Validation.intInputValidation(map.size()));
        }
    }


