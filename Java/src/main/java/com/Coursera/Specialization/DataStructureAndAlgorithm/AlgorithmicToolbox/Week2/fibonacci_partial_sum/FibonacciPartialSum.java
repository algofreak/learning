import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        if (to <= 1)
            return to;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < from - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        long sum = current;

        for (long i = 0; i < to - from; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }

    private static long getFibonacciLastDigit(long n) {
        long first = 0;
        long second = 1;
        long result = 0;
        for (long i = 2; i <= n; i++) {
            result = (first + second) % 10;
            first = second;
            second = result;  
        }
        return result;
    }

    private static long getFibonacciPartialSumsLastDigit(long m, long n) {
        long fib;
        if (m == n) {
            fib = getFibonacciLastDigit(m);
        } else {
            fib = getFibonacciLastDigit(n + 2) - getFibonacciLastDigit(m + 1);
        }
        return fib;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        // System.out.println(getFibonacciPartialSumNaive(from, to));
        System.out.println(getFibonacciPartialSumsLastDigit(from, to));
    }
}
