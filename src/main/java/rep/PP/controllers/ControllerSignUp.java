package rep.PP.controllers;

import animatefx.animation.FadeIn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import rep.PP.exceptions.UsernameAlreadyExistsException;
import rep.PP.services.UserService;

import java.io.IOException;

public class ControllerSignUp {

    @FXML
    private VBox vboxPane;
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField mail;

    @FXML
    private Text registrationMessage;

    public void initialize(){

    }
    @FXML
    void home(ActionEvent event) throws IOException {
        VBox vbox= FXMLLoader.load(getClass().getClassLoader().getResource("AdminSceneBack.fxml"));
        vboxPane.getChildren().setAll(vbox);
        new FadeIn(vbox).play();

    }
    @FXML
    void handleRegisterAction(ActionEvent event) {
        try {
            UserService.addUser(usernameField.getText(), passwordField.getText(), mail.getText());
            registrationMessage.setText("Account created successfully!");
        } catch (UsernameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        }
    }
}
