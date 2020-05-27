package rep.PP;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;
import sun.security.ec.point.AffinePoint;
import sun.security.util.math.ImmutableIntegerModuloP;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public void initialize(URL location, ResourceBundle resources) {

    }
    double x = 0;
    double y = 0;
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
        }
        else {
            stage.setMaximized(true);
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
}
