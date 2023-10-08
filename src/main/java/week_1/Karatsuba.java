package main.java.week_1;

import java.util.ArrayList;

public class Karatsuba {
    public static void main(String[] args) {
        if (args.length != 2) {
            throw new RuntimeException("2 arguments required.");
        }
        int result = karatsuba(Integer.parseInt(args[0]),
                Integer.parseInt(args[1]));
        System.out.println("Result: " + result);
    }

    public static int multiply(int x, int y) {
       return karatsuba(x, y);
    }

    private static int karatsuba(int x, int y) {
        if (x == 0 || y == 0) {
            return 0;
        }
        int n = Integer.toString(x).length();
        int o = Integer.toString(y).length();
        int cleanX = x;
        int cleanY = y;
        int totalZeros = 0;
        // base case
        if (n == 1 && o == 1) {
            return x * y;
        }
        if (n != o) {
            // add some zeros to even out length
            int diff = n - o;
            if (diff > 0) {
                // add zeros to y
                cleanY = (int) (Math.pow(10, diff) * y);
            } else {
                // add zeros to x
                cleanX = (int) (Math.pow(10, Math.abs(diff)) * x);
                n = Integer.toString(cleanX).length();
            }
            totalZeros += Math.abs(diff);
        }
        if (n % 2 != 0) {
            // lengths are the same, add more zeros
            cleanX = cleanX * 10;
            cleanY = cleanY * 10;
            n = Integer.toString(cleanX).length();
            totalZeros += 2;
        }
        // split int, a b c d
        ArrayList<Integer> ab = splitInteger(cleanX);
        ArrayList<Integer> cd = splitInteger(cleanY);

        int a = ab.get(0);
        int b = ab.get(1);
        int c = cd.get(0);
        int d = cd.get(1);
        int term1 = karatsuba(a, c);
        int term2;
        int term3 = karatsuba(b, d);
        // Gauss trick
        term2 = karatsuba((a+b), (c+d)) - term1 - term3;

        int total = (int) (Math.pow(10, n) * term1 + Math.pow(10, n/2.0) * term2 + term3);
        return (int) (total / Math.pow(10, totalZeros));
    }

    private static ArrayList<Integer> splitInteger(int i) {
        String s = Integer.toString(i);
        int n = s.length();
        String s1 = s.substring(0, n/2);
        String s2 = s.substring(n/2);
        ArrayList<Integer> split = new ArrayList<>();
        split.add(Integer.parseInt(s1));
        split.add(Integer.parseInt(s2));
        return split;
    }
}
