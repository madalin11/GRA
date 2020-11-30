package rep.PP.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerHistory implements Initializable {

    @FXML
    private ListView<String> listview;
    @FXML
    private ListView<String> listView1;

    @FXML
    private ListView<String> listView2;

    @FXML
    private ListView<String> listView3;

    @FXML
    private ListView<String> listView4;

    private JSONArray rooms = new JSONArray();
    public void initialize(URL location, ResourceBundle resources) {

        Object p;
        JSONParser parser = new JSONParser();
        try {
            FileReader readFile = new FileReader("src/main/java/rep/PP/data/order.json");
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

            listview.getItems().add("         " + obj.get("name").toString());
            listView1.getItems().add("   "+ obj.get("culoare").toString());
            listView2.getItems().add("   "+ obj.get("interior").toString());
            listView3.getItems().add("        "+ obj.get("jante").toString());
            listView4.getItems().add("        "+ obj.get("feedback").toString());



        }
        //listView.getItems().addAll(rooms);
        listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);



    }
}