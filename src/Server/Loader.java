package Server;

import java.io.IOException;

import Server.View.MediaViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Loader {

    protected void Loader(ActionEvent e, String url) {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(url));

        Stage primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Parent root = null;

        try {
            root = loader.load();

        } catch (IOException ex) {
            System.out.println("OOPS");
            ex.printStackTrace();
        }

        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

    }



}