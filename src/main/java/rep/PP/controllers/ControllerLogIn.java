package rep.PP.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ControllerLogIn {
    @FXML
    public TextField Username;

    @FXML
    public PasswordField Password;

    @FXML
    public Text ErrorMessage;

    @FXML
    void LogInAction(ActionEvent event) {
        String username = Username.getText();
        String password = Password.getText();

        if(username == null || username.isEmpty()){
            ErrorMessage.setText("Please type in a username");
            return;
        }

        if(password == null || password.isEmpty()){
            ErrorMessage.setText("Password cannot be empty");
            return;
        }

        if(username.equals("admin") && password.equals("admin")){
            try{
                Stage stage = (Stage) ErrorMessage.getScene().getWindow();
                Parent viewAdminPage = FXMLLoader.load(getClass().getClassLoader().getResource("AdminScene.fxml"));
                Scene scene = new Scene(viewAdminPage);

                stage.setScene(scene);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        ErrorMessage.setText("Wrong username or password !");
    }


}
