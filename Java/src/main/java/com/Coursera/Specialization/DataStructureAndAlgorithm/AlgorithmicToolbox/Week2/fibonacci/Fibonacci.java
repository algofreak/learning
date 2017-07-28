//import java.util.Scanner;
//import java.math.BigInteger;
//
//public class Fibonacci {
//  private static long calc_fib(int n) {
//    if (n <= 1)
//      return n;
//
//    return calc_fib(n - 1) + calc_fib(n - 2);
//  }
//
//  public static BigInteger calc_linear_fib(long n) {
//    BigInteger result = BigInteger.ZERO;
//    BigInteger previous = BigInteger.ONE;
//    for (long i = 0; i < n; i++) {
//      result = result.add(previous);
//      previous = result.subtract(previous);
//    }
//    return result;
//  }
//
//  public static void main(String args[]) {
//    Scanner in = new Scanner(System.in);
//    int n = in.nextInt();
//
//    //System.out.println(calc_fib(n));
//    System.out.println(calc_linear_fib(n));
//  }
//}
