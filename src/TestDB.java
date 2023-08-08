import java.sql.*;
import java.util.*;

class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "1234";

        return DriverManager.getConnection(url, username, password);
    }
}
public class TestDB {
    public static void main(String[] args) {

        final Routs CI106 = new Routs();

        // chisinue - rome
        final Routs CR212 = new Routs();
        final Routs CR216 = new Routs();
        final Routs CR109 = new Routs();
        final Routs CR120 = new Routs();

        //berlin - london
        final Routs BL118 = new Routs();
        final Routs BL107 = new Routs();
        final Routs BL221 = new Routs();

        //amsterdam - new york
        final Routs AN212 = new Routs();
        final Routs AN201 = new Routs();
        final Routs AN109 = new Routs();
        final Routs AN106 = new Routs();

        HashMap<String, Routs> routsNumber = new HashMap<>();
        routsNumber.put("CR212", CR212);
        routsNumber.put("CR216", CR216);
        routsNumber.put("CI106", CI106);


        try (Connection connection = DatabaseConnection.getConnection()) {


            for (String i : routsNumber.keySet()) {
                String selectQuery = "SELECT * FROM test.routes WHERE routes_number = ?;";

                try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                    preparedStatement.setString(1, i);

                    ResultSet resultSet = preparedStatement.executeQuery();

                    while (resultSet.next()) {
                        // Retrieve data from the result set
                        String airline = resultSet.getString("airline");
                        String departure = resultSet.getString("departure");
                        String destination = resultSet.getString("destination");
                        int flight_days = resultSet.getInt("flight_days");
                        String departure_times = resultSet.getString("departure_times");
                        String arrivalTime = resultSet.getString("arrivalTime");
                        int price = resultSet.getInt("price");

                        // Use the retrieved data as needed
                        /*System.out.println("Airline: " + airline);
                        System.out.println("Departure City: " + departure);
                        System.out.println("destination: " + destination);
                        System.out.println("departure_times " + departure_times);
                        System.out.println();*/

                        routsNumber.get(i).setAirline(airline);
                        routsNumber.get(i).setDeparture(departure);
                        routsNumber.get(i).setDestination(destination);
                        routsNumber.get(i).setFlight_days(flight_days);
                        routsNumber.get(i).setDeparture_times(departure_times);
                        routsNumber.get(i).setArrivalTime(arrivalTime);
                        routsNumber.get(i).setPrice(price);

                        System.out.println(routsNumber);
                        //Set<Routs> routs = new HashSet<>();


                    } //while


                } catch (SQLException e) {
                    e.printStackTrace();
                } //try2

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }






































       /* // Assuming you have a HashSet<Routs> containing your objects
        HashSet<Routs> routesHashSet = new HashSet<>();
        routesHashSet.add(new Routs("WizzAir", "Chisinau", "Iasi", 1, "06:00", "06:40", 25));
        routesHashSet.add(new Routs("AirItaly", "Chisinau", "Rome", 2, "12:30", "15:00", 150));
        routesHashSet.add(new Routs("WizzAir", "Chisinau", "Rome", 2, "16:00", "18:30", 37));

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234")) {
            String insertQuery = "INSERT INTO routes (airline, departure, destination, flight_days, departure_times, arrivalTime, price) VALUES (?, ?, ?, ?, ?, ?, ?)";

            for (Routs route : routesHashSet) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    preparedStatement.setString(1, route.getAirline());
                    preparedStatement.setString(2, route.getDeparture());
                    preparedStatement.setString(3, route.getDestination());
                    preparedStatement.setInt(4, route.getFlight_days());
                    preparedStatement.setString(5, route.getDeparture_times());
                    preparedStatement.setString(6, route.getArrivalTime());
                    preparedStatement.setInt(7, route.getPrice());

                    preparedStatement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}


