package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @FXML
    private ToggleButton player1;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("graphic.fxml"));
        primaryStage.setTitle("Forza 4");
        Image applicationIcon = new Image(getClass().getResourceAsStream("icon.png"));
        primaryStage.getIcons().add(applicationIcon);
        primaryStage.setScene(new Scene(root, 790, 720));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
