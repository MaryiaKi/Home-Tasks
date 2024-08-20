import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Lesson_14.Factorial.calculateFactorial;

public class TestFactorial {
    @Test
    @DisplayName("Check that Factorial 7 is equal 5040")
    public void testFactorial1() {
        Assertions.assertEquals("5040", calculateFactorial(7));
    }

    @Test
    @DisplayName("Check that Factorial 0 is equal 1")
    public void testFactorial2() {
        Assertions.assertEquals("1", calculateFactorial(0));
    }

    @Test
    @DisplayName("Check that Factorial 1 is equal 1")
    public void testFactorial3() {
        Assertions.assertEquals("1", calculateFactorial(1));
    }

    @Test
    @DisplayName("Check Error Message for Negative Factorial")
    public void testFactorial4() {
        Assertions.assertEquals("Entered number cannot be negative", calculateFactorial(-1));
    }
}
