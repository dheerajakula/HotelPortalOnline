package MyPortal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        Parent myPortal = FXMLLoader.load(getClass().getResource("MyPortal.fxml"));

        window.setTitle("Expedeity");
        window.setScene(new Scene(myPortal,600,800));

        window.show();
        JDBCDriverConnection.connect();
        List<City> myCities =JDBCDriverConnection.getCitiesList();
        JDBCDriverConnection.disconnect();
        for(City myCity:myCities){
            System.out.println(myCity.name);
        }
        JDBCDriverConnection.connect();
        List<Hotel> myHotels =JDBCDriverConnection.getHotelsList(myCities.get(0));
        JDBCDriverConnection.disconnect();
        for(Hotel myHotel : myHotels){
            System.out.println(myHotel.name);
        }
        JDBCDriverConnection.connect();
        List<Room> myRooms =JDBCDriverConnection.getRoomsList(myHotels.get(1));
        JDBCDriverConnection.disconnect();
        for(Room myRoom : myRooms){
            System.out.println(myRoom.name);
            System.out.println(myRoom.id);
            System.out.println(myRoom.cost);
            System.out.println(myRoom.isBreakfast);
            System.out.println(myRoom.isWifi);
            System.out.println(myRoom.description);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
