import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
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
   
    private static long getFibonacciSumsLastDigit(long n) {
        return getFibonacciLastDigit(n + 2) - 1;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        // long s = getFibonacciSumNaive(n);
        long s = getFibonacciSumsLastDigit(n);
        System.out.println(s);
    }
}

