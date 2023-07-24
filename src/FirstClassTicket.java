public class FirstClassTicket {

    private String[][] firstClass;




    //constructor
    // добавить валидатор размера массива 4х4
    public FirstClassTicket(String[][] firstClass) {
        for (int row = 0; row < firstClass.length; row++) {

            for (int seat = 0; seat < firstClass[row].length; seat++) {

                char seatLetter = (char) ('A' + seat); // Получение буквы места (A, B, C, ...)
                firstClass[row][seat] = (row + 1) + String.valueOf(seatLetter); // Формирование номера сиденья
            }
        }
        this.firstClass = firstClass;

        for (String[] aClass : firstClass) {
            for (String s : aClass) {
                System.out.print(s + " ");
            }
            System.out.println();
        }



    }

    //setter
    public void setSeatsClass(String[][] firstClass) {
        for (int row = 0; row < firstClass.length; row++) {

            for (int seat = 0; seat < firstClass[row].length; seat++) {

                char seatLetter = (char) ('A' + seat); // Получение буквы места (A, B, C, ...)
                firstClass[row][seat] = (row + 1) + String.valueOf(seatLetter); // Формирование номера сиденья
            }
        }
        this.firstClass = firstClass;

        for (String[] aClass : firstClass) {
            for (String s : aClass) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public String[][] getFirstClass() {
        return firstClass;
    }
}

