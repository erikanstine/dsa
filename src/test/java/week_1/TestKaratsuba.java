package test.java.week_1;

import main.java.week_1.Karatsuba;
import org.junit.jupiter.api.Test;

public class TestKaratsuba {
    @Test
    public void testMultiplication1() {
        assert Karatsuba.multiply(10, 20) == 10 * 20;
    }

    @Test
    public void testOriginalCase() {
        assert Karatsuba.multiply(1234, 5678) == 1234 * 5678;
    }
}
