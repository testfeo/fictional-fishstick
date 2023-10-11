import java.sql.*;
import java.util.*;

public class TestDB {
//class TestDB with methods for interaction with SQL database

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "1234";

        return DriverManager.getConnection(url, username, password);
    }


    public static void uploadRouteToDatabase () {

        //HashSet<Route> with objects
        HashSet<Route> routesHashSet = new HashSet<>();
        routesHashSet.add(new Route("WizzAir", "Chisinau", "Iasi", 1, "06:00", "06:40", 25, "CI106"));
        routesHashSet.add(new Route("AirItaly", "Chisinau", "Rome", 2, "12:30", "15:00", 150, "CR212"));
        routesHashSet.add(new Route("WizzAir", "Chisinau", "Rome", 2, "16:00", "18:30", 37, "CR216"));
        routesHashSet.add(new Route("Flyone", "Chisinau", "Rome", 1, "09:00", "11:30", 95, "CR109"));
        routesHashSet.add(new Route("WizzAir", "Chisinau", "Rome", 1, "20:00", "22:30", 45, "CR120"));
        routesHashSet.add(new Route("BritishAirways", "Berlin", "London", 1, "18:50", "21:10", 230, "BL118"));
        routesHashSet.add(new Route("lufthansa", "Berlin", "London", 1, "07:00", "8:50", 240, "BL107"));
        routesHashSet.add(new Route("lufthansa", "Berlin", "London", 2, "21:45", "23:50", 250, "BL221"));
        routesHashSet.add(new Route("United Airlines", "Amsterdam", "New York", 2, "12:30", "20:40", 1260, "AN212"));
        routesHashSet.add(new Route("Delta Airlines", "Amsterdam", "New York", 2, "01:00", "09:30", 990, "AN201"));
        routesHashSet.add(new Route("KLM Dutch", "Amsterdam", "New York", 1, "09:00", "17:30", 1000, "AN109"));
        routesHashSet.add(new Route("SWISS", "Amsterdam", "New York", 1, "06:00", "14:30", 890, "AN106"));


        try (Connection connection = getConnection()) {
            String insertQuery = "INSERT INTO routes (airline, departure, destination, flight_days, departure_times, arrivalTime, price, routes_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            for (Route route : routesHashSet) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    preparedStatement.setString(1, route.getAirline());
                    preparedStatement.setString(2, route.getDeparture());
                    preparedStatement.setString(3, route.getDestination());
                    preparedStatement.setInt(4, route.getFlight_days());
                    preparedStatement.setString(5, route.getDeparture_times());
                    preparedStatement.setString(6, route.getArrivalTime());
                    preparedStatement.setInt(7, route.getPrice());
                    preparedStatement.setString(8, route.getRoutes_number());

                    preparedStatement.executeUpdate();
                }
            }
            System.out.println("work is done!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void loadRouteFromDatabase() {

        HashMap<String, Route> routsNumber = new HashMap<>();

        final Route CI106 = new Route();
        final Route CR212 = new Route();
        final Route CR216 = new Route();
        final Route CR109 = new Route();
        final Route CR120 = new Route();

        final Route BL118 = new Route();
        final Route BL107 = new Route();
        final Route BL221 = new Route();

        final Route AN212 = new Route();
        final Route AN201 = new Route();
        final Route AN109 = new Route();
        final Route AN106 = new Route();


        routsNumber.put("CI106", CI106);
        routsNumber.put("CR212", CR212);
        routsNumber.put("CR216", CR216);
        routsNumber.put("CR109", CR109);
        routsNumber.put("CR120", CR120);
        routsNumber.put("BL118", BL118);
        routsNumber.put("BL107", BL107);
        routsNumber.put("BL221", BL221);
        routsNumber.put("AN212", AN212);
        routsNumber.put("AN201", AN201);
        routsNumber.put("AN109", AN109);
        routsNumber.put("AN106", AN106);

        try (Connection connection = getConnection()) {

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
                    } //while

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static List<String> loadDepartureFromDatabase() {
        List<String> cities = new ArrayList<>();

        try {
            Connection connection = getConnection();
            String query = "SELECT DISTINCT departure FROM routes";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                cities.add(resultSet.getString("departure"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }


    public static List<String> findDestinationByDeparture(String targetDeparture) {
        List<String> destinations = new ArrayList<>();

        try {
            Connection connection = getConnection();
            String query = "SELECT DISTINCT destination FROM routes WHERE departure = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, targetDeparture);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                destinations.add(resultSet.getString("destination"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return destinations;
    }


    public static List<Route> findRoutes(String targetDeparture, String targetDestination, int targetFlightDays) {
        List<Route> result = new ArrayList<>();
        try {
            Connection connection = getConnection();
            String query = "SELECT * FROM test.routes " +
                    "WHERE departure = ? " +
                    "  AND destination = ? " +
                    "  AND flight_days = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, targetDeparture);
            preparedStatement.setString(2, targetDestination);
            preparedStatement.setInt(3, targetFlightDays);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Route route = new Route();
                route.setAirline(resultSet.getString("airline"));
                route.setDeparture(resultSet.getString("departure"));
                route.setDestination(resultSet.getString("destination"));
                route.setFlight_days(resultSet.getInt("flight_days"));
                route.setDeparture_times(resultSet.getString("departure_times"));
                route.setArrivalTime(resultSet.getString("arrivalTime"));
                route.setPrice(resultSet.getInt("price"));
                route.setRoutes_number(resultSet.getString("routes_number"));

                result.add(route);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static void uploadUserToDatabase(User user) {
        try (Connection connection = getConnection()) {
            String insertQuery = "INSERT INTO users (travelDocumentID, name) VALUES (?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, user.getTravelDocumentID());
                preparedStatement.setString(2, user.getName());

                preparedStatement.executeUpdate();
            }
            System.out.println("work is done!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }










}




