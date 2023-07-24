public class BusinessClassTicket{

    private String[][] businessClass;


    //constructor
    // добавить валидатор размера массива 4х4
    public BusinessClassTicket(String[][] businessClass) {
        for (int row = 0; row < businessClass.length; row++) {

            for (int seat = 0; seat < businessClass[row].length; seat++) {

                char seatLetter = (char) ('A' + seat); // Получение буквы места (A, B, C, ...)
                businessClass[row][seat] = (row + 1) + String.valueOf(seatLetter); // Формирование номера сиденья
            }
        }
        this.businessClass = businessClass;

        for (String[] aClass : businessClass) {
            for (String s : aClass) {
                System.out.print(s + " ");
            }
            System.out.println();
        }



    }

    //setter
    public void setSeatsClass(String[][] businessClass) {
        for (int row = 0; row < businessClass.length; row++) {

            for (int seat = 0; seat < businessClass[row].length; seat++) {

                char seatLetter = (char) ('A' + seat); // Получение буквы места (A, B, C, ...)
                businessClass[row][seat] = (row + 1) + String.valueOf(seatLetter); // Формирование номера сиденья
            }
        }
        this.businessClass = businessClass;

        for (String[] aClass : businessClass) {
            for (String s : aClass) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public String[][] getBusinessClass() {
        return businessClass;
    }

}
