package rep.PP;

import animatefx.animation.FadeIn;
import animatefx.animation.FadeInUp;
import animatefx.animation.Jello;
import animatefx.animation.Pulse;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.paint.Color;
import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MainScene.fxml"));
        primaryStage.setTitle("G.R.A");
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
        new FadeInUp(root).play();
    }




    public static void main(String[] args) {
        launch(args);
    }
}


