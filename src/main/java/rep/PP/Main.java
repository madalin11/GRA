package rep.PP;

import animatefx.animation.FadeInUp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import org.apache.commons.io.FileUtils;
import rep.PP.services.UserService;

import java.io.File;
import java.io.IOException;

public class Main extends Application {
    private static void copyFile(File src, File dest) throws IOException {
        FileUtils.copyFileToDirectory(src, dest);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        UserService.loadUsersFromFile();
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
        File from_carList = new File("src/main/java/rep/PP/data/carList.json").getAbsoluteFile();
        File from_employees = new File("src/main/java/rep/PP/data/employees.json").getAbsoluteFile();
        File from_order = new File("src/main/java/rep/PP/data/order.json").getAbsoluteFile();


        File to = new File("target/src/main/java/rep/PP/data");

        try{
            copyFile(from_carList, to);
            copyFile(from_employees, to);
            copyFile(from_order, to);

        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        launch(args);
    }
}


