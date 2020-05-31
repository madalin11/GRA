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
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMainScene implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private VBox rootPaneVbox;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private VBox vboxAllRights;

    @FXML
    private VBox vboxTitleGra;


    @FXML
    private StackPane animat;

    @FXML
    private Circle c1;

    @FXML
    private Circle c2;

    @FXML
    private Circle c3;

    @FXML
    private Button b1;

    @FXML
    private Button b2;

    @FXML
    private Button b3;

    @FXML
    private Button b4;

    @FXML
    private StackPane termsAndCond;

    @FXML
    private Button b5;

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
            new FadeInLeftBig(rootPane).play();
            button();
            stage.setMaximized(false);
        }
        else {

            stage.setMaximized(true);
            new FadeInLeftBig(rootPane).play();
            button2();

        }
    }
    @FXML
    void loadMainScene(ActionEvent event) throws IOException {
        VBox vbox= FXMLLoader.load(getClass().getClassLoader().getResource("BackScene.fxml"));
        rootPane.getChildren().setAll(vbox);
        new  FadeInLeft(rootPane).play();
        button();
    }

    public void button() {
        new Jello(b1).play();
        new FadeInUp(b2).play();
        new Pulse(b3).play();
        new RollIn(b4).play();
        new Flash(b5).play();
        new FadeInLeft(vboxTitleGra).play();
        new Jello(animat).play();
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
        button2();

    }

    public void button2() {
        new Jello(b1).play();
        new BounceInRight(b2).play();
        new Flip(b3).play();
        new Bounce(b4).play();
        new Swing(b5).play();
        new Wobble(animat).play();
        new Bounce(vboxAllRights).play();
        new FadeInLeft(vboxTitleGra).play();
    }

    @FXML
    void setTermsScene(ActionEvent event) throws IOException {
        VBox vbox1  = FXMLLoader.load(getClass().getClassLoader().getResource("TermsScene.fxml"));
        rootPane.getChildren().setAll(vbox1);
        button2();
        new FadeIn(vbox1).play();
    }
}
