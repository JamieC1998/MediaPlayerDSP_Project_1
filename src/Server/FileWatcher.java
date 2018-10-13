package Server;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class FileWatcher {

    private List<ClientInterface> clients = new ArrayList<>();

    private String directoryAddress = null;

    private File folder = null;

    public FileWatcher(String directoryName){

        directoryAddress = directoryName;

        folder = new File(directoryAddress);

        if(folder.isDirectory() == false){
            folder = null;

            System.err.println("Address entered is not a valid directory");

        }



    }

    public void PrintListFiles(){
        if(folder == null)
            return;

        File[] listOfFiles = folder.listFiles();

        for(File fileEntry : listOfFiles){
            System.out.println("File: \t" + fileEntry.getName());
            System.out.println("Last modified: \t" + new SimpleDateFormat().format(fileEntry.lastModified()));
        }
    }

    public String[] ReturnFileNames(){
        if(folder == null){
            System.err.println("Folder not found");
            return null;
        }

        String[] returnList = new String[folder.listFiles().length];

        for(int i = 0; i < returnList.length; i++){
            returnList[i] = folder.listFiles()[i].getName();
        }

        return returnList;
    }

    public File[] ReturnListOfFiles(){
        if(folder == null){
            System.err.println("Folder not found");
            return null;
        }

        return folder.listFiles();
    }


}
