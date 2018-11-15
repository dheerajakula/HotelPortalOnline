package MyPortal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class JDBCDriverConnection {
    static Connection conn = null;
    static Statement stmt = null;

    public static void connect() {

        try {
            // db parameters
            String url = "jdbc:sqlite:mydatabase.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void disconnect(){

        try {
            if (conn != null) {
                conn.close();
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static boolean authenticateUser(String submittedUsername,String submittedPassword){
        boolean authenticated = false;

        try{

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users");
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String  username = rs.getString("username");
                String  password = rs.getString("password");
                //String dob = rs.getString("dob");
                //String email = rs.getString("email");
                //String address = rs.getString("address");
                if(username.equals(submittedUsername)&&password.equals(submittedPassword)){
                    authenticated = true;
                }

            }

            rs.close();
            stmt.close();

        }

        catch (SQLException e){
            System.out.println("nope");
            System.out.println(e);
            System.exit(0);
        }
        return authenticated;
    }

    public static List<City> getCitiesList(){
        Stack<City> myCitiesList = new Stack<>();
        try{

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from cities");
            while ( rs.next() ) {
                City myCity ;
                int id = rs.getInt("id");
                String  name = rs.getString("name");
                myCity  = new City(id,name);
                myCitiesList.push(myCity);
            }

            rs.close();
            stmt.close();

        }

        catch (SQLException e){
            System.out.println("nope");
            System.out.println(e);
            System.exit(0);
        }

        return myCitiesList;
    }

    public static List<Hotel> getHotelsList(City myCity){
        Stack<Hotel> myHotelsList = new Stack<>();
        try{
            int myCity_id = myCity.id;
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from hotels inner join cities on hotels.city_id = cities.id where cities.id =" + myCity_id);
            while ( rs.next() ) {
                Hotel myHotel ;
                int id = rs.getInt("id");
                String  name = rs.getString("name");
                myHotel = new Hotel(id,name);
                myHotelsList.push(myHotel);
            }

            rs.close();
            stmt.close();

        }

        catch (SQLException e){
            System.out.println("nope");
            System.out.println(e);
            System.exit(0);
        }

        return myHotelsList;
    }

    public static List<Room> getRoomsList(Hotel myHotel){
        Stack<Room> myRoomsList = new Stack<>();
        try{
            int myHotel_id = myHotel.id;
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from rooms inner join hotels on rooms.hotel_id = hotels.id where hotels.id =" + myHotel_id);
            while ( rs.next() ) {
                Room myRoom ;
                int id = rs.getInt("id");
                String  name = rs.getString("name");
                float cost = rs.getFloat("cost");
                boolean isBreakfast = rs.getBoolean("isbreakfast");
                boolean isWifi = rs.getBoolean("iswifi");
                String description = rs.getString("description");

                myRoom = new Room(id,name,cost,isBreakfast,isWifi,description);
                myRoomsList.push(myRoom);
            }

            rs.close();
            stmt.close();

        }

        catch (SQLException e){
            System.out.println("nope");
            System.out.println(e);
            System.exit(0);
        }

        return myRoomsList;
    }
}
