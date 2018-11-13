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

public class SignUpController implements Initializable
{
    public TextField nameTextField;
    public TextField dateofbirthTextField;
    public TextField emailTextField;
    public TextField addressTextField;
    public TextField usernameTextField;
    public PasswordField passwordPasswordField;
    public Button signupButton;
    public Button loginButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        System.out.println("Register kar BC!");
        signupButton.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent actionEvent)
                {
                    Stage currentWindow = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
                    // boolean authenticated = false;
                    JDBCDriverConnection.connect();
                    //JDBCDriverConnection.CreateUser(nameTextField.getText(), dateofbirthTextField.getText() , emailTextField.getText() , addressTextField.getText() , usernameTextField.getText(),passwordPasswordField.getText());
                    JDBCDriverConnection.disconnect();
                    if(true)
                    {
                        Parent myPortal = null;
                        try{
                            myPortal = FXMLLoader.load(getClass().getResource("MyPortal.fxml"));
                        }
                        catch (Exception e){
                            System.out.println(e);
                        }
                        currentWindow.setTitle("Register");
                        currentWindow.setScene(new Scene(myPortal  , 1280  , 720));
                        currentWindow.show();
                    }
                   // System.out.println();

                }
            }
        );
        loginButton.setOnAction(new EventHandler<ActionEvent>()
        {
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
                currentWindow.setScene(new Scene(login  , 1280  , 720));
                currentWindow.show();
            }
        });

    }

}

