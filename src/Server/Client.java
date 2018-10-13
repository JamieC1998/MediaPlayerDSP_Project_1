package Server;

import java.util.Observable;
import java.util.Observer;

public class Client implements Observer{

    String item;

    @Override
    public void update(Observable o, Object arg) {
        this.setItem((String) arg);
    }

}
