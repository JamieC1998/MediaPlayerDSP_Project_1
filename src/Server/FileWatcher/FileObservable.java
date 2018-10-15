package Server.FileWatcher;

import java.util.Arrays;
import java.util.Observable;

public class FileObservable extends Observable implements Runnable{

    String[] fileName;

    @Override
    public void run() {

        FileWatcherInterface fW = new FileWatcher("C:\\Users\\Admin\\Documents\\College Documents\\Generic Eclipse Workspace\\DistributedSystemsProgramming\\src\\Server\\FileFolder");

        while(true) {
            try {

                String[] temp = fW.ReturnFileNames();

                if (!Arrays.equals(this.fileName, temp)) {
                    setChanged();
                    notifyObservers(temp);
                    fileName = temp;

                }

                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
