package rep.PP.controllers;

import animatefx.animation.FadeIn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ControllerSignUp {

    @FXML
    private VBox vboxPane;

    @FXML
    void home(ActionEvent event) throws IOException {
        VBox vbox= FXMLLoader.load(getClass().getClassLoader().getResource("AdminSceneBack.fxml"));
        vboxPane.getChildren().setAll(vbox);
        new FadeIn(vbox).play();

    }
}
