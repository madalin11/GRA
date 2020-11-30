package rep.PP.controllers;

import animatefx.animation.FadeIn;
import animatefx.animation.FadeInLeft;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import rep.PP.model.EmployeeClass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerTeam implements Initializable {

    @FXML
    private ListView<String> listView;
    @FXML
    private ListView<String> listView1;

    @FXML
    private ListView<String> listView2;

    @FXML
    private ListView<String> listView3;


    private JSONArray rooms = new JSONArray();
    public void initialize(URL location, ResourceBundle resources) {

        Object p;
        JSONParser parser = new JSONParser();
        try {
            FileReader readFile = new FileReader("src/main/java/rep/PP/data/employees.json");
            BufferedReader read = new BufferedReader(readFile);
            p = parser.parse(read);
            if (p instanceof JSONArray) {
                rooms = (JSONArray) p;
            }

        } catch (ParseException | IOException ex) {
            ex.printStackTrace();
        }

        for (int i=0;i<rooms.size();i++) {

            JSONObject obj=(JSONObject) rooms.get(i);

            listView.getItems().add("         " + obj.get("name").toString() );
            listView1.getItems().add("        "+obj.get("firstname").toString());
            listView2.getItems().add("        "+obj.get("CNP").toString());
            listView3.getItems().add("        "+obj.get("role").toString());




        }
        //listView.getItems().addAll(rooms);
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);



    }

    @FXML
    private VBox vboxemp;

    @FXML
    void addEmployee(ActionEvent event) throws IOException {
        VBox vbox= FXMLLoader.load(getClass().getClassLoader().getResource("AddEmployee.fxml"));
        vboxemp.getChildren().setAll(vbox);
        new FadeInLeft(vboxemp).play();
    }

    @FXML
    void backAdminScene(ActionEvent event) throws IOException {
        VBox vbox= FXMLLoader.load(getClass().getClassLoader().getResource("AdminSceneBack.fxml"));
        vboxemp.getChildren().setAll(vbox);
        new FadeIn(vbox).play();
    }
}