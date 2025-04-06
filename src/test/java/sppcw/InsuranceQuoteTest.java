package sppcw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsuranceQuoteTest {

    // Test ID 1: To check that the premium is the base premium when total risk is less than 5.
    @Test
    public void testPremiumWhenTotalRiskLessThan5() {
        Car stubCar = new Car("Toyota", "Yaris", 5, 2025) {
            @Override
            public int carRating() {
                return 1;
            }
            @Override
            public int driverRisk() {
                return 3;
            }
        };
        InsuranceQuote quote = new InsuranceQuote(stubCar, 500);
        assertEquals(500.0, quote.calculatePremium(),
                "Premium should be 500.0 when total risk (1 + 3 = 4) is less than 5.");
    }

    // Test ID 2: To Test for when total risk is >= 5 and < 10, so premium is base premium x 1.5.
    @Test
    public void testPremiumWhenTotalRiskBetween5And9() {
        Car stubCar = new Car("Toyota", "Yaris", 5, 2025) {
            @Override
            public int carRating() {
                return 3;
            }
            @Override
            public int driverRisk() {
                return 4;
            }
        };
        InsuranceQuote quote = new InsuranceQuote(stubCar, 500);
        assertEquals(750.0, quote.calculatePremium(),
                "Premium should be 750.0 when total risk (3 + 4 = 7) is between 5 and 9.");
    }

    // Test ID 3: To test for when total risk is >= 10 and < 15, so premium is base premium x 2.0.
    @Test
    @Tag("Important")
    public void testPremiumWhenTotalRiskBetween10And14() {
        Car stubCar = new Car("Toyota", "Yaris", 5, 2025) {
            @Override
            public int carRating() {
                return 6;
            }
            @Override
            public int driverRisk() {
                return 7;
            }
        };
        InsuranceQuote quote = new InsuranceQuote(stubCar, 500);
        assertEquals(1000.0, quote.calculatePremium(),
                "Premium should be 1000.0 when total risk (6 + 7 = 13) is between 10 and 14.");
    }

    // Test ID 4: To check for when total risk is >= 15 and the car is not uninsurable.
    @Test
    public void testPremiumWhenTotalRiskGreaterThan15() {
        Car stubCar = new Car("Toyota", "Yaris", 5, 2025) {
            @Override
            public int carRating() {
                return 8;
            }
            @Override
            public int driverRisk() {
                return 10;
            }
        };
        InsuranceQuote quote = new InsuranceQuote(stubCar, 500);
        assertEquals(1500.0, quote.calculatePremium(),
                "Premium should be 1500.0 when total risk (8 + 10 = 18) is between 15 and 99.");
    }

    // Test ID 5: To validate that a very high total risk (>= 100) results in an uninsurable premium.
    @Test
    public void testPremiumWhenTotalRiskAtLeast100() {
        Car stubCar = new Car("Toyota", "Yaris", 5, 2025) {
            @Override
            public int carRating() {
                return 100;
            }
            @Override
            public int driverRisk() {
                return 5;
            }
        };
        InsuranceQuote quote = new InsuranceQuote(stubCar, 500);
        assertEquals(0.0, quote.calculatePremium(),
                "Premium should be 0.0 when total risk (100 + 5 = 105) is 100 or greater.");
    }
}
