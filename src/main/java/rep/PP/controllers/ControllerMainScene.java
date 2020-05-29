package rep.PP.controllers;

import animatefx.animation.*;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMainScene implements Initializable {

    @FXML
    private StackPane rootPane;

    @FXML
    private ImageView closebutton;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Circle c1;

    @FXML
    private Circle c2;

    @FXML
    private Circle c3;

    @FXML
    private Button carsListButton;

    @FXML
    private Button logInButton;

    @FXML
    private Button termsAndConditionsbutton;

    @FXML
    private StackPane termsAndCond;


    public void initialize(URL location, ResourceBundle resources) {
    setRotate(c1,true,180,10);
    setRotate(c2,true,360,18);
    setRotate(c3,true,360,5);
    }
    double x = 0;
    double y = 0;

    private void setRotate(Circle c1 , boolean reverse , int angle , int duration){
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(duration),c1);

        rotateTransition.setAutoReverse(reverse);
        rotateTransition.setByAngle(angle);
        rotateTransition.setDelay(Duration.seconds(0));
        rotateTransition.setRate(3);
        rotateTransition.setCycleCount(200);
        rotateTransition.play();
    }

    @FXML
    void close(javafx.scene.input.MouseEvent event) {
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();

    }

    @FXML
    void MAX(javafx.scene.input.MouseEvent event) {
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();

        if(stage.isMaximized()) {

            stage.setMaximized(false);
            new FadeInUp(borderPane).play();
        }
        else {

            stage.setMaximized(true);
            new Pulse(borderPane).play();
        }
    }

    @FXML
    void MIN(javafx.scene.input.MouseEvent event) {
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setIconified(true);


    }


    @FXML
     void dragged(javafx.scene.input.MouseEvent mouseEvent) {

        Node node = (Node) mouseEvent.getSource();
        Stage stage= (Stage) node.getScene().getWindow();
        stage.setX(mouseEvent.getScreenX()-x);
        stage.setY(mouseEvent.getScreenY()-y);
    }

     @FXML
     void pressed(javafx.scene.input.MouseEvent mouseEvent) {

         x=  mouseEvent.getSceneX();
         y=mouseEvent.getSceneY();
    }

    @FXML
    void loadCarsList(ActionEvent event) throws IOException {
        VBox vbox= FXMLLoader.load(getClass().getClassLoader().getResource("CarsListScene.fxml"));
        rootPane.getChildren().setAll(vbox);
        new FadeIn(vbox).play();

    }
    @FXML
    void setTermsScene(ActionEvent event) throws IOException {
        VBox vbox1  = FXMLLoader.load(getClass().getClassLoader().getResource("TermsScene.fxml"));
        rootPane.getChildren().setAll(vbox1);
        new FadeIn(vbox1).play();
    }
}
