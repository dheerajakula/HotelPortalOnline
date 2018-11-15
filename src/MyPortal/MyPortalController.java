package MyPortal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MyPortalController implements Initializable {
    public TextField usernameTextField;
    public PasswordField passwordPasswordField;
    public Button loginButton;
    public Button signupButton;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("hello");
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage currentWindow = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
                boolean authenticated = false;
                JDBCDriverConnection.connect();
                authenticated=JDBCDriverConnection.authenticateUser(usernameTextField.getText(),passwordPasswordField.getText());
                JDBCDriverConnection.disconnect();
                if(authenticated){
                    Parent bookingPortal = null;
                    try{
                        bookingPortal = FXMLLoader.load(getClass().getResource("BookingPortal.fxml"));
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }

                    currentWindow.setTitle("Hello World");
                    currentWindow.setScene(new Scene(bookingPortal  , 1280  , 720));
                    currentWindow.show();
                }
                System.out.println(authenticated);
            }
        });
        signupButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                Stage currentWindow = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
                Parent signup = null;
                try {
                    signup = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                }
                catch (Exception e) {
                    System.out.println(e);
                }

                currentWindow.setTitle("Hello World");
                currentWindow.setScene(new Scene(signup,600,800));
                currentWindow.show();


            }
        });
    }

}

