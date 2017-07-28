//import java.util.*;
//import java.math.BigInteger;
//
//public class Fibonacci1 {
//    public static void main(String[] args) {
//        BigInteger a = BigInteger.ZERO;
//        BigInteger b = new BigInteger("200");
//        int n = Integer.valueOf(args[0]);
//        // System.out.println(fibonacciRec(n));
//        System.out.println(fibonacciLinear(n));
//        // System.out.println(fibonacci(n));
//    }
//
//    public static long fibonacciRec(int n) { return (n <= 1) ? (long) n : fibonacci(n - 1) + fibonacci(n - 2); }
//
//    public static BigInteger fibonacciLinear(long n) {
//        BigInteger result = BigInteger.ZERO;
//        BigInteger previous = BigInteger.ONE;
//        for (long i = 0; i < n; i++) {
//            result = result.add(previous);
//            previous = result.subtract(previous);
//        }
//        return result;
//    }
//
//    public static long fibonacci(long n) {
//        long result = 0;
//        long previous = 1;
//        for (long i = 0; i < n; i++) {
//            long tmp = result;
//            result += previous;
//            previous = tmp;
//            // System.out.println("i: " + i + ", previous: " + previous + ", result: " + result);
//        }
//        return result;
//    }
//}
