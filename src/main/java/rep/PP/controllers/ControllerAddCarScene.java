package rep.PP.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import rep.PP.exceptions.EmployeeAlreadyExistsException;
import rep.PP.services.CarService;
import rep.PP.services.EmployeeService;

public class ControllerAddCarScene {
    @FXML
    private TextField name;
    @FXML
    private TextField interior;

    @FXML
    private TextField pret;

    @FXML
    private TextField culoare;

    @FXML
    private TextField jante;
    @FXML
    private Text message;

    @FXML
    void addCar(ActionEvent event) {
        CarService.addCar(name.getText(), pret.getText(), interior.getText(), culoare.getText(),jante.getText());
        message.setText("Car added successfully!");
    }
}