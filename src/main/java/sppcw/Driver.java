package sppcw;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Driver {
    private String name;
    private int age;
    private int accidents;

    public int riskRating() {
        int rating = 1;
        if (age < 25) {
            rating *= 6;
        }
        if (age >= 75){
            rating *= 3;
        }
        rating += accidents * 3;
        return rating;
    }
}

// Added a comment for CI testing purposes.
// malaika