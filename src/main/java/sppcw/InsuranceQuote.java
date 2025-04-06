package sppcw;

public class InsuranceQuote {
    private static final double PREMIUM_MULTIPLIER_LOW = 1.0;
    private static final double PREMIUM_MULTIPLIER_MEDIUM = 1.5;
    private static final double PREMIUM_MULTIPLIER_HIGH = 2.0;
    private static final double PREMIUM_MULTIPLIER_VERY_HIGH = 3.0;

    private double basePremium;
    private Car car;

    public InsuranceQuote(Car car, double basePremium) {
        this.car = car;
        this.basePremium = basePremium;
    }

    public double calculatePremium() {
        int carRating = car.carRating();
        int driverRisk = car.driverRisk();

        int totalRisk = carRating + driverRisk;

        if (totalRisk < 5) {
            return basePremium * PREMIUM_MULTIPLIER_LOW;
        } else if (totalRisk < 10) {
            return basePremium * PREMIUM_MULTIPLIER_MEDIUM;
        } else if (totalRisk < 15) {
            return basePremium * PREMIUM_MULTIPLIER_HIGH;
        } else if (totalRisk < 100) {
            return basePremium * PREMIUM_MULTIPLIER_VERY_HIGH;
        } else {
            return 0.0;
        }
    }
}


// Added a comment for CI testing purposes.