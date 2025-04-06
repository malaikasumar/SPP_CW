package sppcw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CarTest {

    // Test ID 1: To validate car rating for a new car with a valid insurance group and current production year.
    @Test
    public void testNewCarRating() {
        int currentYear = 2025;
        Car car = new Car("Toyota", "Yaris", 5, currentYear);
        assertEquals(5, car.carRating(), "New car with insurance group 5 and production year 2025 should have a rating 5.");
    }

    // Test ID 2: To verify an invalid insurance group (<= 0 or > 10) sets the car to uninsurable.
    @Test
    public void testInvalidInsuranceGroup() {
        int currentYear = 2025;
        Car car = new Car("Toyota", "Yaris", 15, currentYear);
        assertEquals(100, car.carRating(), "Car with invalid insurance group (15) should be uninsurable.");
    }

    // Test ID 3: To test behavior for an older car (> 25 years old) to ensure uninsurable
    @Test
    @Tag("Important")
    public void testOlderCarRatingUninsurable() {
        int currentYear = 2025;
        Car car = new Car("Toyota", "Yaris", 3, 1998);
        assertEquals(100, car.carRating(), "Car age 27 years, should have a rating of 100 - uninsurable.");
    }

    // Test ID 4: To test for a car in the age range (>= 5 and <= 25).
    @Test
    public void testMiddleAgedCarRating() {
        int currentYear = 2025;
        Car car = new Car("Toyota", "Yaris", 4, 2015);
        assertEquals(6, car.carRating(), "Car age 10 years, should have rating of 6.");
    }

    // Test ID 5: To confirm default driver risk when no driver is added.
    @Test
    public void testDefaultDriverRiskNoDrivers() {
        Car car = new Car("Toyota", "Yaris", 5, 2025);
        assertEquals(0, car.driverRisk(), "Car with no drivers should return a default driver risk of 5.");
    }

    // Test ID 6: To verify that the maximum risk among multiple drivers is used.
    @Test
    public void testMaximumDriverRisk() {
        Car car = new Car("Toyota", "Yaris", 5, 2025);
        car.addDriver(new Driver("Oliver", 20, 1));
        car.addDriver(new Driver("Sarah", 40, 2));
        assertEquals(9, car.driverRisk(), "The maximum driver risk among multiple drivers should be 9.");
    }

    // Test ID 7: To validate driver removal using removeDriverByName() for an existing driver and then for a non-existent driver.
    @Test
    public void testDriverRemovalByName() {
        Car car = new Car("Toyota", "Yaris", 5, 2025);
        car.addDriver(new Driver("Sarah", 25, 0));
        car.addDriver(new Driver("Oliver", 30, 1));
        boolean firstRemoval = car.removeDriverByName("Sarah");
        boolean secondRemoval = car.removeDriverByName("Sarah");
        assertTrue(firstRemoval, "Removing an existing driver 'Sarah' should return true.");
        assertFalse(secondRemoval, "Attempting to remove 'Sarah' again should return false.");

    }

}
