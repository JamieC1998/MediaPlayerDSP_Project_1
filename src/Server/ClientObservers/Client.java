package Server.ClientObservers;

import java.util.Observable;
import java.util.Observer;

public class Client implements Observer{

    String[] fileName;

    @Override
    public void update(Observable o, Object arg) {
        this.setFileName((String[]) arg);

        System.out.println("Update: ");

        for(String each : fileName)
                System.out.println(each);

        System.out.println();
    }

    private void setFileName(String[] val){
        this.fileName = val;

    }
}
