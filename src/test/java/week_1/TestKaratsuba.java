package test.java.week_1;

import java.math.BigInteger;
import main.java.week_1.Karatsuba;
import org.junit.jupiter.api.Test;

public class TestKaratsuba {
    @Test
    public void testMultiplication1() {
        assert Karatsuba.multiply(BigInteger.valueOf(10), BigInteger.valueOf(20)).compareTo(BigInteger.valueOf(10).multiply(BigInteger.valueOf(20))) == 0;
    }

    @Test
    public void testOriginalCase() {
        assert Karatsuba.multiply(BigInteger.valueOf(1234), BigInteger.valueOf(5678)).compareTo(BigInteger.valueOf(1234).multiply(BigInteger.valueOf(5678))) == 0;
    }
}
