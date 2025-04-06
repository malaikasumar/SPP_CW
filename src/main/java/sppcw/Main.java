package sppcw;

// example usage
public class Main {
    public static void main(String[] args) {
        Car car = new Car("Ford", "Puma", 5, 2020);

        System.out.println(car.addDriver(new Driver("Bob", 43, 1)) + " drivers");
        System.out.println(car.addDriver(new Driver("Alice", 39, 0)) + " drivers");
        InsuranceQuote quote = new InsuranceQuote(car, 500);

        System.out.println("Calculated Premium: £" + quote.calculatePremium());
        System.out.println("Car rating: " + car.carRating());
        System.out.println("Max driver risk: " + car.driverRisk());
        System.out.println("-------------------------------");

        System.out.println(car.addDriver(new Driver("Junior", 19, 1)) + " drivers");
        quote = new InsuranceQuote(car, 500);

        System.out.println("Calculated Premium: £" + quote.calculatePremium());
        System.out.println("Car rating: " + car.carRating());
        System.out.println("Max driver risk: " + car.driverRisk());
        System.out.println("-------------------------------");

        System.out.println(car.removeDriverByName("Junior") ? "driver removed" : "no driver removed");
        quote = new InsuranceQuote(car, 500);

        System.out.println("Calculated Premium: £" + quote.calculatePremium());
        System.out.println("Car rating: " + car.carRating());
        System.out.println("Max driver risk: " + car.driverRisk());
        System.out.println("-------------------------------");
    }
}
