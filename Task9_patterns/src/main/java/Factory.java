
import java.util.Date;

public class Factory {

    public static void main(String[] args) {
        // write your code here
        Maker maker = new RomeWatchMaker(); //new DigitalWatchMaker();
        Watch watch = maker.createWatch();
        watch.showTime();
    }
}

interface Watch{
    void showTime();
}

class DigitalWatch implements Watch{
    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}

class RomanWatch implements Watch{
    @Override
    public void showTime() {
        System.out.println("XX-XV");
    }
}

interface Maker{
    Watch createWatch();
}

class DigitalWatchMaker implements Maker{
    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}
class RomeWatchMaker implements Maker{
    @Override
    public Watch createWatch() {
        return new RomanWatch();
    }
}