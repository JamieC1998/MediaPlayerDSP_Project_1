package Server.View;

import Server.ClientObservers.Client;
import Server.FileWatcher.FileObservable;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ServerMain extends Application {

    public static void main(String[] args){

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Home.fxml"));

        Parent root = null;

        try { root = loader.load(); }
        catch (IOException e) { e.printStackTrace(); }

        primaryStage.setTitle("Media Player");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
