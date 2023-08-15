public class User {
    private String name;
    private String travelDocumentID;

    //constructor
    public User() {}

    public User (String name, String travelDocumentID) {
        this.name = name;
        this.travelDocumentID = travelDocumentID;
    }


    // get/set
    public void setTravelDocumentID(String travelDocumentID) {
        this.travelDocumentID = travelDocumentID;
    }
    public String getTravelDocumentID() {
        return travelDocumentID;
    }

    public void setName (String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }



}
