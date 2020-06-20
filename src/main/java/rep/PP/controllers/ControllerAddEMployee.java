package rep.PP.controllers;

import animatefx.animation.FadeIn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import rep.PP.exceptions.EmployeeAlreadyExistsException;
import rep.PP.exceptions.UsernameAlreadyExistsException;
import rep.PP.services.EmployeeService;
import rep.PP.services.UserService;

import java.io.IOException;

public class ControllerAddEMployee {
    @FXML
    private TextField name;

    @FXML
    private TextField firstname;

    @FXML
    private TextField role;

    @FXML
    private TextField cnp;

    @FXML
    private VBox vboxadd;

    @FXML
    private Text message;

    @FXML
    void addEmp(ActionEvent event) {
        try {
            EmployeeService.addEmployee(name.getText(), role.getText(), cnp.getText(), firstname.getText());
            message.setText("Account created successfully!");
        } catch (EmployeeAlreadyExistsException e) {
            message.setText(e.getMessage());
        }
    }

    @FXML
    void backEmp(ActionEvent event) throws IOException {
        VBox vbox= FXMLLoader.load(getClass().getClassLoader().getResource("TeamScene.fxml"));
        vboxadd.getChildren().setAll(vbox);
        new FadeIn(vbox).play();
    }
}