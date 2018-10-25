package Server.View;

import Server.ClientObservers.Client;
import Server.FileWatcher.FileObservable;
import Server.FileWatcher.FileWatcher;
import Server.FileWatcher.FileWatcherInterface;
import Server.Loader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class HomeScreenController extends Loader {

    @FXML
    public ListView<String> lvLocal;

    @FXML
    public ListView<String> lvServer;

    @FXML
    public Button play;

    @FXML
    public Button download;

    @FXML
    public SplitPane splitPane;

    private String serverDirectory = "C:\\Users\\Admin\\Documents\\College Documents\\Generic Eclipse Workspace\\DistributedSystemsProgramming\\src\\Server\\FileFolder";

    private String localDirectory = "C:\\Users\\Admin\\Documents\\College Documents\\Generic Eclipse Workspace\\DistributedSystemsProgramming\\src\\Server\\FileLocal";

    @FXML
    public void initialize(){

        //Server

        FileObservable fileObservable = new FileObservable(serverDirectory);

        ObservableList<String> observableList = FXCollections.observableArrayList();

        Client clientObservable = new Client(observableList);

        fileObservable.addObserver(clientObservable);

        Thread t = new Thread(fileObservable);

        t.start();

        lvServer.setItems(observableList);

        //Local
        FileObservable fileObservableLocal = new FileObservable(localDirectory);

        ObservableList<String> observableListLocal = FXCollections.observableArrayList();

        Client clientObservableLocal = new Client(observableListLocal);

        fileObservableLocal.addObserver(clientObservableLocal);

        Thread tLocal = new Thread(fileObservableLocal);

        tLocal.start();

        lvLocal.setItems(observableListLocal);

    }

    @FXML
    public void Download(ActionEvent e){

        String item = lvServer.getSelectionModel().getSelectedItem();

        FileWatcherInterface fw = new FileWatcher(serverDirectory);

        FileWatcherInterface fIns = new FileWatcher(localDirectory);

        ((FileWatcher) fIns).AddFile(((FileWatcher) fw).ReturnFileReq(item));

    }


    @FXML
    public void PlayFile(ActionEvent e){
        FileWatcherInterface fileWatcherLocal = new FileWatcher(localDirectory);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("MediaView.fxml"));

        Parent root = null;

        try {
            root = (Parent) loader.load();

        } catch (IOException ex) {
            System.out.println("OOPS");
            ex.printStackTrace();
        }

        MediaViewController returnObject = loader.getController();

        String item = lvLocal.getSelectionModel().getSelectedItem();

        File file = (((FileWatcher) fileWatcherLocal).ReturnFileReq(item));

        System.out.println(file.getName());

        if(returnObject == null){
            System.out.println("NULL");
        }

        Stage primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        returnObject.setFile(file);


    }


}
