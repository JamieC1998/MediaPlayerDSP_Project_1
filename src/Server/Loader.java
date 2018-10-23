package Server;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Loader {

    private static Loader ld;

    protected void Loader(ActionEvent e, String url) {

        Stage primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource(url));
        } catch (IOException ex) {
            System.out.println("OOPS");
            ex.printStackTrace();
        }

        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    public static Loader getInstance(){

        if(ld == null)
            ld = new Loader();

        return ld;
    }

}