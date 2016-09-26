
public class AbstractFactory {

    public static void main(String[] args) {
        // write your code here
    }
}

interface Mouse {
    void click();

    void dbclick();

    void scroll(int direction);
}

interface Keyboard {
    void print();

    void println();
}

interface Touchpad {
    void track(int deltaX, int deltaY);
}

interface DeviceFactory {
    Mouse getMouse();

    //  Keyboard getKeyboard();

//    Touchpad getTouchpad();
}

class RuMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("Click");
    }

    @Override
    public void dbclick() {
        System.out.println("DblClick");
    }

    @Override
    public void scroll(int direction) {
        if (direction > 0)
            System.out.println("Вверх");
        else if (direction < 0)
            System.out.println("Ввниз");
        else
            System.out.println("не скролим");
    }
}

class EnMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("Шелчок");
    }

    @Override
    public void dbclick() {
        System.out.println("Двойной");
    }

    public void scroll(int direction) {
        if (direction > 0)
            System.out.println("Goes up");
        else if (direction < 0)
            System.out.println("Goes down");
        else
            System.out.println("no dcroll");
    }

}

class EnDeviceFactory implements DeviceFactory {
    @Override
    public Mouse getMouse() {
        return new EnMouse();
    }
}

class RuDeviceFactory implements DeviceFactory {
    @Override
    public Mouse getMouse() {
        return new RuMouse();
    }
}