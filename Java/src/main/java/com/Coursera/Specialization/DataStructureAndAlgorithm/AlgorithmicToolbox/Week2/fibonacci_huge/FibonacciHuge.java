import java.util.*;
import java.math.BigInteger;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }

    private static long getPisanoPeriod(long m) {
        long x = 0;
        long y = 1;
        long z = x + y;

        for (long i = 0; i < m * m; i++) {
            z = (x + y) % m;
            x = y;
            y = z;
            if (x == 0 && y == 1) {
                return i + 1;
            }
        }
        return 0;
    }

    public static BigInteger fibonacciLinear(long n) {
        BigInteger result = BigInteger.ZERO;
        BigInteger previous = BigInteger.ONE;
        for (long i = 0; i < n; i++) {
            result = result.add(previous); 
            previous = result.subtract(previous);
        }
        return result;
    }

    private static long getFibonacciMod(long n, long m) {
        long pisano = getPisanoPeriod(m);
        long reminder = n % pisano;
        return fibonacciLinear(reminder).mod(BigInteger.valueOf(m)).longValue();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        // System.out.println(getFibonacciHugeNaive(n, m));
        System.out.println(getFibonacciMod(n, m));
    }
}

