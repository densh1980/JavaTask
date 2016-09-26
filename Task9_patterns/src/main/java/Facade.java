
public class Facade {


    public static void main(String[] args) {
        // write your code here
        Power power = new Power();
        power.on();

        DvdRom dvdRom = new DvdRom();
        dvdRom.load();

        Hdd hdd = new Hdd();
        hdd.copyFromDVD(dvdRom);
    }
}

class Power {
    void on() {
        System.out.println("On");
    }

    void off() {
        System.out.println("Off");
    }
}

class DvdRom {
    private boolean data = false;

    public boolean hasDat() {
        return data;
    }

    void load() {
        data = true;
    }

    void unload() {
        data = false;
    }
}

class Hdd {
    void copyFromDVD(DvdRom dvd) {
        if (dvd.hasDat()) {
            System.out.println("Copeing data");
        } else {
            System.out.println("No CD with Data");
        }
    }
}
