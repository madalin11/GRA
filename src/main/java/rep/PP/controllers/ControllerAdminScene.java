package rep.PP.controllers;

import animatefx.animation.FadeIn;
import animatefx.animation.FadeInLeftBig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import rep.PP.services.EmployeeService;

import java.io.IOException;

public class ControllerAdminScene {
    @FXML
    private VBox vboxpane;

    @FXML
    private VBox vboxPaneSign;

    @FXML
    void CLOSE(javafx.scene.input.MouseEvent event) {
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void MAX(javafx.scene.input.MouseEvent event) {
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();

        if(stage.isMaximized()) {
            new FadeInLeftBig(vboxpane).play();
            stage.setMaximized(false);
        }
        else {

            stage.setMaximized(true);
            new FadeInLeftBig(vboxpane).play();

        }
    }

    @FXML
    void MIN(javafx.scene.input.MouseEvent event) {
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void dragged1(javafx.scene.input.MouseEvent mouseEvent) {
        Node node = (Node) mouseEvent.getSource();
        Stage stage= (Stage) node.getScene().getWindow();
        stage.setX(mouseEvent.getScreenX()-x);
        stage.setY(mouseEvent.getScreenY()-y);
    }
    double x = 0;
    double y = 0;
    @FXML
    void pressed1(javafx.scene.input.MouseEvent mouseEvent) {
        x=  mouseEvent.getSceneX();
        y=mouseEvent.getSceneY();
    }

    @FXML
    void goSalesScene(ActionEvent  event) {


    }
    @FXML
    void GoSignUp(ActionEvent event) throws IOException {
        VBox vbox= FXMLLoader.load(getClass().getClassLoader().getResource("SignUpScene.fxml"));
        vboxPaneSign.getChildren().setAll(vbox);
        new FadeIn(vbox).play();
    }
    @FXML
    void goTeamList(ActionEvent  event) throws IOException {
        EmployeeService.loadEmployeesFromFile();
        VBox vbox= FXMLLoader.load(getClass().getClassLoader().getResource("TeamScene.fxml"));
        vboxPaneSign.getChildren().setAll(vbox);
        new FadeIn(vbox).play();
    }

    @FXML
    void backMainScene(ActionEvent event) throws IOException {
        Stage stage = (Stage) vboxpane.getScene().getWindow();
        Parent viewAdminPage = FXMLLoader.load(getClass().getClassLoader().getResource("MainScene.fxml"));
        Scene scene = new Scene(viewAdminPage);

        stage.setScene(scene);
    }
}