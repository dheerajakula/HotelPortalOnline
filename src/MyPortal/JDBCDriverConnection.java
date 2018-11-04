package MyPortal;

import java.sql.*;

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
}
