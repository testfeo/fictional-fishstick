import java.util.Scanner;

public class User {
    private String name;
    private String travelDocumentID;

    static Scanner scan = new Scanner(System.in);


    public User() {}
    public User (String name, String travelDocumentID) {
        this.name = name;
        this.travelDocumentID = travelDocumentID;
    }


    //get/set
    public void setTravelDocumentID(String travelDocumentID) {
        this.travelDocumentID = travelDocumentID;
    }
    public void setName (String name) {
        this.name = name;
    }
    public String getTravelDocumentID() {
        return travelDocumentID;
    }
    public String getName() {
        return name;
    }


    public static User getUserInformation() {
        User user = new User();

        System.out.println("PASSENGER \n" +
              "-enter your full name-");
        user.name = Validation.UserFullNameValidation();

        System.out.println("-enter your travel document ID-");
        user.travelDocumentID = Validation.UserDocumentValidation();

        TestDB.uploadUserToDatabase(user);
        return user;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", travelDocumentID='" + travelDocumentID + '\'' +
                '}';
    }
}
