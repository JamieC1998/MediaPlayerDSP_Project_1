package Server;

import Server.ClientObservers.Client;
import Server.FileWatcher.FileObservable;
import Server.FileWatcher.FileWatcher;

public class ServerMain{

    public static void main(String[] args){

        FileWatcher fW = new FileWatcher("C:\\Users\\Admin\\Documents\\College Documents\\Generic Eclipse Workspace\\DistributedSystemsProgramming\\src\\Server\\FileFolder");

        FileObservable fileObservable = new FileObservable();

        Client clientObservable = new Client();

        fileObservable.addObserver(clientObservable);

        fileObservable.setFileName("Test");


    }
}
