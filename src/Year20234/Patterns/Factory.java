package Year20234.Patterns;

public class Factory {
    public static void main(String[] args) {
        Car smallCar = CarFactory.buildCar(CarType.SMALL);
        Car sedanCar = CarFactory.buildCar(CarType.SEDAN);
        Car luxuryCar = CarFactory.buildCar(CarType.LUXURY);

        System.out.println(smallCar.getCarInfo());
        System.out.println(sedanCar.getCarInfo());
        System.out.println(luxuryCar.getCarInfo());
    }
}

enum CarType {
    SMALL, SEDAN, LUXURY
}

class CarFactory {
    public static Car buildCar(CarType model) {
        Car car = null;
        switch (model) {
            case SMALL -> {
                car = new SmallCar();
            }
            case SEDAN -> {
                car = new SedanCar();
            }
            case LUXURY -> {
                car = new LuxuryCar();
            }
            default -> {
                System.out.println("Invalid car type.");
            }
        }
        return car;
    }
}

abstract class Car {
    public abstract String getCarInfo();
}

class SmallCar extends Car {
    @Override
    public String getCarInfo() {
        return "Small car.";
    }
}

class SedanCar extends Car {
    @Override
    public String getCarInfo() {
        return "Sedan car.";
    }
}

class LuxuryCar extends Car {
    @Override
    public String getCarInfo() {
        return "Luxury car.";
    }
}
