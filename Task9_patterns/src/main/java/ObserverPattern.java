import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

    public static void main(String[] args) {
        // write your code here
        MeteoStation observerd = new MeteoStation();

        observerd.addObserver(new ConsoleObserver());
        observerd.addObserver(new FileObserver());
        observerd.serMesuares(25,50);
        observerd.serMesuares(25,55);
    }
}

interface Observerd{
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();

}

class MeteoStation implements Observerd{
    int temp;
    int pressure;

    public void serMesuares(int t, int p){
        pressure = p;
        temp = t;
        notifyObserver();
    }

    List<Observer> observers = new ArrayList<>();
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (Observer o: observers)
            o.handleEvent(temp,pressure);
    }
}

interface Observer{

    void handleEvent(int temp, int presser);
}

class ConsoleObserver implements Observer{
    @Override
    public void handleEvent(int temp, int presser) {
        System.out.println("OGOGOGOGOOG POGODA " + temp + " Pressssssure " + presser);
    }
}

class FileObserver implements Observer{
    @Override
    public void handleEvent(int temp, int presser) {
        System.out.println("YA NOVYIII " + temp + " PressssssureNOVYII " + presser);
    }
}
