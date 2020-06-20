package rep.PP.controllers;

import animatefx.animation.FadeIn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import rep.PP.exceptions.UsernameAlreadyExistsException;
import rep.PP.services.OrderService;
import rep.PP.services.UserService;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

public class ControllerConfigScene implements Initializable {
    ObservableList<String> ch1StatusList= FXCollections.observableArrayList("BMW","Mercedes","Audi" );
    ObservableList<String> ch2StatusList= FXCollections.observableArrayList("Alb","Albastru","Negru","Rosu" );
    ObservableList<String> ch3StatusList= FXCollections.observableArrayList("15","16","19" );
    ObservableList<String> ch4StatusList= FXCollections.observableArrayList("Piele neagra","Material textil","Piele alba" );
    ObservableList<String> ch5StatusList= FXCollections.observableArrayList("1 star","2 stars","3 stars","4 stars","5 stars" );

    @FXML
    private ChoiceBox<String> ch1name;
    @FXML
    private ChoiceBox<String> ch5feed;
    @FXML
    private ChoiceBox<String> ch2culoare;

    @FXML
    private ChoiceBox<String> ch3dimJant;

    @FXML
    private ChoiceBox<String> ch3Int;

    @FXML
    private VBox vBoxConfig;

    @FXML
    private Text message;

    public void initialize(URL location, ResourceBundle resources){
        ch1name.setValue("BMW");
        ch2culoare.setValue("Alb");
        ch3dimJant.setValue("15");
        ch3Int.setValue("Piele neagra");
        ch5feed.setValue("4 stars");
        ch1name.setItems(ch1StatusList);
        ch2culoare.setItems(ch2StatusList);
        ch3dimJant.setItems(ch3StatusList);
        ch3Int.setItems(ch4StatusList);
        ch5feed.setItems(ch5StatusList);
    }
    @FXML
    void backCarlistScene(ActionEvent event) throws IOException {
        VBox vbox= FXMLLoader.load(getClass().getClassLoader().getResource("CarsListScene.fxml"));
        vBoxConfig.getChildren().setAll(vbox);
        new FadeIn(vbox).play();
    }

    @FXML
    void placeOrder(ActionEvent event) {
        OrderService.addOrder(ch1name.getValue(), ch2culoare.getValue(), ch3dimJant.getValue(),ch3Int.getValue(),ch5feed.getValue());
        message.setText("Order created successfully!");
    }
}
