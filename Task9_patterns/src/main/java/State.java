public class State {
    public static void main(String[] args) {


        Human human = new Human();
        human.setState(new Work());
        for (int i = 0; i < 10; i++) {
            human.doSomething();
        }


    }
}

class Human {
    private Activity state;

    public void setState(Activity s) {
        this.state = s;
    }

    public void doSomething() {
        state.doSomething(this);
    }
}

interface Activity {
    void doSomething(Human context);
}

class Work implements Activity {
    public void doSomething(Human context) {
        System.out.println("Work!!");
        context.setState(new WeekEnd());
    }
}

class WeekEnd implements Activity {
    private int count = 0;

    public void doSomething(Human context) {
        if (count < 3) {
            System.out.println("Rest (Zzz)");
            count++;
        } else {
            context.setState(new Work());
        }
    }

}


interface Station {
    void play();
}

class Radio7 implements Station {
    @Override
    public void play() {
        System.out.println("Radio 7...");

    }
}

class RadioDFM implements Station {
    @Override
    public void play() {
        System.out.println("Radio DFM...");

    }
}

class VestiFM implements Station {
    @Override
    public void play() {
        System.out.println("Vesti FM...");

    }
}

class Radio {
    Station station;

    void setStation(Station st) {
        station = st;
    }

    void nextStation() {
        if (station instanceof Radio7) {
            setStation(new RadioDFM());
        } else if (station instanceof RadioDFM) {
            setStation(new VestiFM());
        } else if (station instanceof VestiFM) {
            setStation(new Radio7());
        }

    }

    void play() {
        station.play();
    }


}

