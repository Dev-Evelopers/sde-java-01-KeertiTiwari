import java.util.*;
abstract class AbstractInheritance {
    private boolean isSedan;
    private String seats;

    public AbstractInheritance(boolean isSedan, String seats) {
        this.isSedan = isSedan;
        this.seats = seats;
    }

    public boolean getIsSedan() {
        return isSedan;
    }

    public String getSeats() {
        return seats;
    }

    abstract String getMileage();
}

class WagonR extends AbstractInheritance {
    private int mileage;

    public WagonR(int mileage) {
        super(false, "4");
        this.mileage = mileage;
    }

    @Override
    String getMileage() {
        return mileage + " kmpl";
    }
}

class HondaCity extends AbstractInheritance {
    private int mileage;

    public HondaCity(int mileage) {
        super(true, "4");
        this.mileage = mileage;
    }

    @Override
    String getMileage() {
        return mileage + " kmpl";
    }
}

class InnovaCrysta extends AbstractInheritance {
    private int mileage;

    public InnovaCrysta(int mileage) {
        super(false, "6");
        this.mileage = mileage;
    }

    @Override
    String getMileage() {
        return mileage + " kmpl";
    }
}
public class Inheritance {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int type = sc.nextInt();   
            int mileage = sc.nextInt();

            AbstractInheritance car = null;

            if (type == 0) {
                car = new WagonR(mileage);
            } else if (type == 1) {
                car = new HondaCity(mileage);
            } else if (type == 2) {
                car = new InnovaCrysta(mileage);
            }

            // Print details
            System.out.println("Car is " + (car.getIsSedan() ? "" : "not ") + "Sedan, " 
                               + "Seats = " + car.getSeats() + ", Mileage = " + car.getMileage());
        }
    }
}
