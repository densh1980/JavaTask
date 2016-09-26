public class Builder {
    public static void main(String[] args) {
        Car car = new CarBuilder()
                .buildMake("Mercedes")
                .buildTransmisson(Transmission.Manual)
                .buildMaxSpeed(220)
                .build();

        System.out.println(car);

        Director director = new Director();
        director.setBuilder(new SubaruBuilder());

        Car car3 = director.buildCar();
        System.out.println(car3);

    }
}
 class Car {
    String make;
    Transmission transmission;
    int maxSpeed;

    public void setMake(String make) {
        this.make = make;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", transmission=" + transmission +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
abstract class CarBuilderII {
    Car car;

    void createCar(){
        car = new Car();
    }

    abstract void buildMake();
    abstract void buildTransmission();
    abstract void buildMaxSpeed();

    Car getCar(){
        return car;
    }


}
class CarBuilder {
    String m = "Default";
    Transmission tr = Transmission.Manual;
    int s = 120;

    CarBuilder buildMake(String m){
        this.m = m;
        return this;
    }

    CarBuilder buildTransmisson(Transmission tr){
        this.tr = tr;
        return this;
    }

    CarBuilder buildMaxSpeed(int s){
        this.s = s;
        return this;
    }

    Car build(){
        Car car = new Car();
        car.setMake(m);
        car.setTransmission(tr);
        car.setMaxSpeed(s);
        return car;
    }

}
 class Director {
    CarBuilderII builder;
    void setBuilder(CarBuilderII builder){
        this.builder = builder;
    }

    Car buildCar(){
        builder.createCar();
        builder.buildMake();
        builder.buildTransmission();
        builder.buildMaxSpeed();
        Car car = builder.getCar();
        return car;
    }
}
 class FordMondeoBuilder extends CarBuilderII{

    @Override
    void buildMake() {
        car.setMake("Ford Mondeo");

    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.Auto);

    }

    @Override
    void buildMaxSpeed() {
        car.setMaxSpeed(200);

    }
}
class SubaruBuilder extends CarBuilderII{

    @Override
    void buildMake() {
        car.setMake("Subaru");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.Manual);

    }

    @Override
    void buildMaxSpeed() {
        car.setMaxSpeed(250);

    }
}
 enum Transmission {
    Manual, Auto
}