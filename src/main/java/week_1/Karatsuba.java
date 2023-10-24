package week_1;

import java.math.BigInteger;
import java.util.ArrayList;

public class Karatsuba {
    public static void main(String[] args) {
        if (args.length != 2) {
            throw new RuntimeException("2 arguments required.");
        }
    BigInteger result = karatsuba(new BigInteger(args[0]), new BigInteger(args[1]));
        System.out.println("Result: " + result);
    }

    public static BigInteger multiply(BigInteger x, BigInteger y) {
       return karatsuba(x, y);
    }

    private static BigInteger karatsuba(BigInteger x, BigInteger y) {
        if (x.compareTo(BigInteger.ZERO) == 0 || y.compareTo(BigInteger.ZERO) == 0) {
      return BigInteger.ZERO;
        }
        int n = x.toString().length();
        int o = y.toString().length();
        BigInteger cleanX = x;
        BigInteger cleanY = y;
        int totalZeros = 0;
        // base case
        if (n == 1 && o == 1) {
            return x.multiply(y);
        }
        if (n != o) {
            // add zeros to even out length
            int diff = n - o;
            if (diff > 0) {
                // add zeros to y
                BigInteger additionalZeros = BigInteger.valueOf(10).pow(diff);
                cleanY = y.multiply(additionalZeros);
            } else {
                // add zeros to x
                BigInteger additionalZeros = BigInteger.valueOf(10).pow(Math.abs(diff));
                cleanX = x.multiply(additionalZeros);
                n = cleanX.toString().length();
            }
            totalZeros += Math.abs(diff);
        }
        if (n % 2 != 0) {
            // lengths are the same, add another zero to make even number
            cleanX = cleanX.multiply(BigInteger.valueOf(10));
            cleanY = cleanY.multiply(BigInteger.valueOf(10));
            n = cleanX.toString().length();
            totalZeros += 2;
        }
        // split into a b c d
        ArrayList<BigInteger> ab = splitInteger(cleanX);
        ArrayList<BigInteger> cd = splitInteger(cleanY);

        BigInteger a = ab.get(0);
        BigInteger b = ab.get(1);
        BigInteger c = cd.get(0);
        BigInteger d = cd.get(1);
        BigInteger term1 = karatsuba(a, c);
        BigInteger term2;
        BigInteger term3 = karatsuba(b, d);
        // Gauss trick
        term2 = karatsuba(a.add(b), c.add(d)).subtract(term1).subtract(term3);
        BigInteger total = term1.multiply(BigInteger.valueOf(10).pow(n)).add(term2.multiply(BigInteger.valueOf(10).pow(n/2))).add(term3);
        return total.divide(BigInteger.valueOf(10).pow(totalZeros));
    }

    private static ArrayList<BigInteger> splitInteger(BigInteger i) {
        String s = i.toString();
        int n = s.length();
        String s1 = s.substring(0, n/2);
        String s2 = s.substring(n/2);
        ArrayList<BigInteger> split = new ArrayList<>();
        split.add(new BigInteger(s1));
        split.add(new BigInteger(s2));
        return split;
    }
}
