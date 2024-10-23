package strategy;

import java.util.Comparator;

public class Bus {
    private int number;
    private String model;
    private int mileage;

    public Bus(int number, String model, int mileage) {
        this.number = number;
        this.model = model;
        this.mileage = mileage;
    }

    public int getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

}


