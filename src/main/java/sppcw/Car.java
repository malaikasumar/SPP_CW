package sppcw;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Car {
    private String make;
    private String model;
    private int insuranceGroup;
    private int year;
    private double value;
    private List<Driver> drivers;

    public Car(String make, String model, int insuranceGroup, int year) {
        this.make = make;
        this.model = model;
        this.insuranceGroup = insuranceGroup <= 0 || insuranceGroup  > 10 ? 100 : insuranceGroup;
        this.year = year;
        this.drivers = new ArrayList<>();
    }

    public int addDriver(Driver driver){
        drivers.add(driver);
        return drivers.size();
    }

    public boolean removeDriverByName(String name) {
        int initialSize = drivers.size();
        drivers = drivers.stream()
                .filter(driver -> !driver.getName().equals(name))
                .collect(Collectors.toList());
        return drivers.size() < initialSize;
    }

    public int driverRisk(){
        int maxRisk = 0;
        for(Driver d : drivers) {
            if(d.riskRating() > maxRisk) {
                maxRisk = d.riskRating();
            }
        }
        return maxRisk;
    }

    public int carRating(){
        int rating = 1;
        rating *= insuranceGroup;
        int age =  Year.now().getValue() - year;
        if(age > 25){
            rating = 100;
        } else {
            rating += age / 5;
        }
        return rating;
    }

}
