import org.testng.Assert;
import org.testng.annotations.Test;

import static Lesson_14.Factorial.calculateFactorial;

public class TestFactorial {
    @Test(description="Check that Factorial 7 is equal 5040")
    public void testFactorial1() {
        Assert.assertEquals("5040", calculateFactorial(7));
    }

    @Test(description="Check that Factorial 0 is equal 1")
    public void testFactorial2() {
        Assert.assertEquals("1", calculateFactorial(0));
    }

    @Test(description="Check that Factorial 1 is equal 1")
    public void testFactorial3() {
        Assert.assertEquals("1", calculateFactorial(1));
    }

    @Test(description="Check Error Message for Negative Factorial")
    public void testFactorial4() {
        Assert.assertEquals("Entered number cannot be negative", calculateFactorial(-1));
    }
}

