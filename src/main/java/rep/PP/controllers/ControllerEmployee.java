package rep.PP.controllers;

import animatefx.animation.FadeIn;
import animatefx.animation.FadeInLeft;
import animatefx.animation.FadeInLeftBig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerEmployee {
    double x = 0;
    double y = 0;

    @FXML
    private VBox vbox;

    @FXML
    private HBox hbox;
    @FXML
    private VBox vboxPane;

    @FXML
    void CLOSE(MouseEvent event) {
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    @FXML
    void viewHistoric(ActionEvent event) throws IOException {
        VBox vbox= FXMLLoader.load(getClass().getClassLoader().getResource("HistoryScene.fxml"));
        vboxPane.getChildren().setAll(vbox);
        new FadeIn(vbox).play();

    }
    @FXML
    void addCar(ActionEvent event) throws IOException {
        VBox vbox= FXMLLoader.load(getClass().getClassLoader().getResource("AddCarScene.fxml"));
        vboxPane.getChildren().setAll(vbox);
        new FadeInLeft(vboxPane).play();

    }

    @FXML
    void backmain(ActionEvent event) throws IOException {
        Stage stage = (Stage) vbox.getScene().getWindow();
        Parent viewAdminPage = FXMLLoader.load(getClass().getClassLoader().getResource("MainScene.fxml"));
        Scene scene = new Scene(viewAdminPage);

        stage.setScene(scene);
    }
    @FXML
    void MAX(MouseEvent event) {
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();

        if(stage.isMaximized()) {
            new FadeInLeftBig(vbox).play();
            stage.setMaximized(false);
        }
        else {

            stage.setMaximized(true);
            new FadeInLeftBig(vbox).play();

        }
    }

    @FXML
    void MIN(MouseEvent event) {
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void pressed(javafx.scene.input.MouseEvent mouseEvent) {

        x=  mouseEvent.getSceneX();
        y=mouseEvent.getSceneY();
    }

    @FXML
    void dragged( javafx.scene.input.MouseEvent mouseEvent) {
        Node node = (Node) mouseEvent.getSource();
        Stage stage= (Stage) node.getScene().getWindow();
        stage.setX(mouseEvent.getScreenX()-x);
        stage.setY(mouseEvent.getScreenY()-y);
    }
}