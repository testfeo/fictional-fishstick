public class Thinking {
/////////// SHOW ALL ROUTS WE HAVE
         /*   System.out.println(
                    "----------------------------- 1. Show all flight FROM -----------------------------"
            );

            Scanner scan = new Scanner(System.in);

            int mainMenuChoice = scan.nextInt();
            switch (mainMenuChoice) {
                case 1:
                     //call metod ->
                    break;
                default:
                    System.out.println("something wrong");

    ////////////////////////
            String choiceFrom;



            switch (choiceFrom) {
                case 1:
                    controller.displayFlightsDetails();
                    break;

            switch (choiceFrom) {
                case 1:
                    controller.displayFlightsDetails();
                    break;
                case 2:
                    controller.addFlight();
                    break;
}
   /* MyObject[] array = new MyObject[5];
            array[0] = new MyObject("apple");
            array[1] = new MyObject("banana");
            array[2] = new MyObject("orange");
            array[3] = new MyObject("grape");
            array[4] = new MyObject("melon");
    */
// Field value to search for
String searchField = "orange";

           /* // Searching for the object
            MyObject foundObject = null;
            for (MyObject obj : array) {
                if (obj.getField().equals(searchField)) {
                    foundObject = obj;
                    break; // Break the loop when the object is found
                }
            }

            // Check if the object was found or not
            if (foundObject != null) {
                System.out.println("Object found: " + foundObject);
            } else {
                System.out.println("Object not found");
            }
        }
    }*/

    /*class MyObject {
        private String field;

        public MyObject(String field) {
            this.field = field;
        }

        public String getField() {
            return field;
        }

        @Override
        public String toString() {
            return "MyObject[field=" + field + "]";
        }
    }*/



            /*//Routs ROMLOND = new WizzairRoutes("Roma", "London", 2, "14:00");
            //ROMLOND.setDeparture("Iasi");

            User user1 = new User("Maria Alger", "AS1243F");
            //FirstClassTicket firstClass = new FirstClassTicket();

            // RoutesDataBase.getKVRM14() хоть и иниц.в классе с базами, но всё еще объект класса wizz
            Ticket ticket1 = new Ticket(RoutesDataBase.getKVRM14(), 20, user1, new FirstClassTicket(new String[4][4]));
            Set<String> set = new HashSet<>();


            // если я делаю через инам. то встает вопрос. мы делаем класс seats и через switch case. проверять то мы можем,
            // но куда заносить все это? занести в свитч кейсе не получится, потому что это будет


            FirstClassTicket classOfSeats;
            Scanner scan = new Scanner(System.in);
            String userSeats = scan.nextLine(); //то что ввел юзер,какой класс сидения

            System.out.println("chose youre class seats");


            switch (userSeats)  {
                case "Econom" :
                    classOfSeats = new FirstClassTicket(new String[4][20]);
                    break;
                case "Fist Class" :
                    classOfSeats = new FirstClassTicket(new String[4][4]);

            }
    */

           /* // Заполнение массива сидений
            for (int row = 0; row < Seat.seatingPlan.length; row++) {

                for (int seat = 0; seat < Seat.seatingPlan[row].length; seat++) {

                    char seatLetter = (char) ('A' + seat); // Получение буквы места (A, B, C, ...)
                    Seat.seatingPlan[row][seat] = (row + 1) + String.valueOf(seatLetter); // Формирование номера сиденья
                }
            }

            for (int row = 0; row < Seat.seatingPlan.length; row++) {
                for (int seat = 0; seat < Seat.seatingPlan[row].length; seat++) {
                    System.out.print(Seat.seatingPlan[row][seat] + " ");
                }
                System.out.println();
            }
    */


} //MAIN


