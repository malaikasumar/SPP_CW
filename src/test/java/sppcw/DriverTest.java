package sppcw;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DriverTest {

    // Test ID 1: check risk rating for a young driver under 25 with no accidents
    @Test
    @Tag("Important")
    public void testYoungDriverNoAccidents() {
        Driver driver = new Driver("Oliver", 20, 0);
        assertEquals(6,driver.riskRating(), "Young driver aged 20 and 0 accidents, should have a risk rating of 6");
    }

    // Test ID 2: Verify risk rating for a young driver (age < 25) with one accident.
    @Test
    public void testYoungDriverOneAccident() {
        Driver driver = new Driver("Sarah", 20, 1);
        assertEquals(9,driver.riskRating(), "Young driver aged 20 and 1 accidents, should have a risk rating of 9");
    }

    // Test ID 3: To verify boundary condition at exactly age 25.
    @Test
    public void testDriverAtBoundaryAge25() {
        Driver driver = new Driver("Malaika", 25, 0);
        assertEquals(1,driver.riskRating(), "Driver aged 25 and 0 accidents, should have a risk rating of 1");
    }

    // Test ID 4: Verify behavior at the senior boundary (age = 75)
    @Test
    public void testDriverAtSeniorBoundaryAge75() {
        Driver driver = new Driver("Daniel", 75, 0);
        assertEquals(3,driver.riskRating(), "Driver aged 75 and 0 accidents, should have a risk rating of 3");
    }

    // Test ID 5: To verify risk rating for a senior driver (age > 75) with multiple accidents.
    @Test
    public void testSeniorDriverMultipleAccidents() {
        Driver driver = new Driver("Jessica", 80, 2);
        assertEquals(9,driver.riskRating(), "Senior driver aged 80 and 2 accidents, should have a risk rating of 9");
    }

    // Test ID 6: To verify risk rating for a middle-aged driver with multiple accidents.
    @Test
    public void testMiddleAgedDriverMultipleAccidents() {
        Driver driver = new Driver("Luke", 40, 2);
        assertEquals(7,driver.riskRating(), "Middle-aged driver aged 40 and 2 accidents, should have a risk rating of 7");
    }

    // Test ID 7: To check risk rating for a young driver with a high accident count.
    @Test
    public void testYoungDriverHighAccidentCount() {
        Driver driver = new Driver("Aisha", 20, 10);
        assertEquals(36,driver.riskRating(), "Young driver aged 20 and 10 accidents, should have a risk rating of 36");
    }
}
