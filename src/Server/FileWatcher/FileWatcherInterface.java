package Server.FileWatcher;

import java.io.File;
import java.text.SimpleDateFormat;

public interface FileWatcherInterface {

    public void PrintListFiles();

    public String[] ReturnFileNames();

    public File[] ReturnListOfFiles();
}
