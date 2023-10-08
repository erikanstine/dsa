package test.java.week_1;

import main.java.week_1.Karatsuba;
import org.junit.jupiter.api.Test;

public class TestKaratsuba {
    @Test
    public void testMultiplication1() {
        String[] testCase = {"10", "20"};
        assert Karatsuba.multiply(testCase) == 10 * 20;
    }

    @Test
    public void testOriginalCase() {
        String[] testCase = {"1234", "5678"};
        assert Karatsuba.multiply(testCase) == 1234 * 5678;
    }
}
