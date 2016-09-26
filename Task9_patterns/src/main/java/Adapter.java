
public class Adapter {

    public static void main(String[] args) {
        // write your code here
        VectorGraphics g1 = new VectorAdapteFromRaster();
        g1.drawLine();
        g1.drawSquare();
    }
}

interface VectorGraphics{
    void drawLine();
    void drawSquare();
}

class ResetGraphics{
    void drawRasterLine(){
        System.out.println("Draw line");
    }
    void drawRasterSquare(){
        System.out.println("Рисуется квадрат");
    }
}

class VectorAdapteFromRaster extends ResetGraphics implements VectorGraphics{

    public void drawLine() {
        drawRasterLine();
    }

    public void drawSquare() {
        drawRasterSquare();
    }
}