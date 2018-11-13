package MyPortal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        Parent myPortal = FXMLLoader.load(getClass().getResource("MyPortal.fxml"));

        window.setTitle("Expedeity");
        window.setScene(new Scene(myPortal, 600  , 500));
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
