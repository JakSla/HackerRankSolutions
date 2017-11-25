import java.util.*;

/**
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler002
 */
public class euler002_EvenFibonacciNumbers {

    public static long getSumOfFibo(long sumFind) {
        long fib1 = 1;
        long fib2 = 1;
        long sumFound = 0;
        for (int i = 2; i <= sumFind; i++) {
            long fib = fib1 + fib2;
            if (fib % 2 == 0 && fib < sumFind) sumFound += fib;
            if (fib > sumFind) return sumFound;
            fib1 = fib2;
            fib2 = fib;
        }
        return sumFound;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTests = sc.nextInt();
        for (int i = 0; i < numTests; i++) {
            long n = sc.nextLong();
            long sum = getSumOfFibo(n);
            System.out.println(sum);
        }
    }
}