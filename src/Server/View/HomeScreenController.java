package Server.View;

import Server.ClientObservers.Client;
import Server.FileWatcher.FileObservable;
import Server.FileWatcher.FileWatcher;
import Server.FileWatcher.FileWatcherInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;

public class HomeScreenController {

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

    }





}
