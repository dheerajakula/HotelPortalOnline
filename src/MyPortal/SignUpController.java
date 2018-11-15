package MyPortal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class SignUpController implements Initializable
{
    public TextField nameTextField;
    public DatePicker dateofbirthDatePicker;
    public TextField emailTextField;
    public TextField addressTextField;
    public TextField usernameTextField;
    public PasswordField passwordPasswordField;
    public Button signupButton;
    public Button loginButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Register kar BC!");
        signupButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent)
                {
                    boolean userCreated = false;
                    Stage currentWindow = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
                    JDBCDriverConnection.connect();
                    Date date = java.sql.Date.valueOf(dateofbirthDatePicker.getValue());
                    userCreated = JDBCDriverConnection.createUser(nameTextField.getText(),date, emailTextField.getText() , addressTextField.getText() , usernameTextField.getText(),passwordPasswordField.getText());
                    JDBCDriverConnection.disconnect();
                    if(userCreated) {
                        Parent myPortal = null;
                        try {
                            myPortal = FXMLLoader.load(getClass().getResource("MyPortal.fxml"));
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        currentWindow.setTitle("Register");
                        currentWindow.setScene(new Scene(myPortal,600,800));
                        currentWindow.show();
                    }

                }
            }
        );
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent)
                {
                    Stage currentWindow = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
                    Parent login = null;
                    try
                        {
                            login = FXMLLoader.load(getClass().getResource("MyPortal.fxml"));
                        }
                    catch (Exception e)
                        {
                            System.out.println(e);
                        }

                    currentWindow.setTitle("Back to login window");
                    currentWindow.setScene(new Scene(login,600,800));
                    currentWindow.show();
                }
            }
        );

    }

}

