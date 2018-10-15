package Server;

import Server.ClientObservers.Client;
import Server.FileWatcher.FileObservable;
import Server.FileWatcher.FileWatcher;

public class ServerMain{

    public static void main(String[] args){

        FileObservable fileObservable = new FileObservable();

        Client clientObservable = new Client();

        fileObservable.addObserver(clientObservable);

        Thread t = new Thread(fileObservable);

        t.start();


    }
}
