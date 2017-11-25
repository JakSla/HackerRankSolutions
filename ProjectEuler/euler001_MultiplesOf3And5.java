import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler001/problem
 */
public class euler001_MultiplesOf3And5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            long n = in.nextLong();
            System.out.println(sumOfMultiples(n, 3) + sumOfMultiples(n, 5) - sumOfMultiples(n, 15));
        }
    }

    private static long sumOfMultiples(long n, long multiple) {
        long numberOfMultiples = countMultiples(n, multiple);
        return (multiple * (numberOfMultiples * ((numberOfMultiples) + 1) / 2));
    }

    private static long countMultiples(long num, long multiple) {
        return (num - 1) / multiple;
    }
}