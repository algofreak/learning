package com.InterviewCake;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author: pgajjar
 * @since: 9/7/17
 */
public class FibMemoize {

    private static Map<Integer, Long> fib = Maps.newHashMap();

    public static long fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        long fib = 0;
        long prev1 = 1;
        long prev2 = 0;
        for (int i = 2; i <= n; i++) {
            fib = prev1 + prev2;
            prev2 = prev1;
            prev1 = fib;
        }

        return fib;
    }

    public static int fibonacciRec(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fibonacciRec(n - 1) + fibonacciRec(n - 2);
    }

    public static long fibonacciRecMem(int n) {
        if (fib.containsKey(n)) {
            // System.out.println("Already computed fibonacciRecMem(" + n + ")");
            return fib.get(n);
        }

        if (n == 0 || n == 1) {
            fib.put(n, (long) n);
            return n;
        }

        long ans = fibonacciRecMem(n - 1) + fibonacciRecMem(n - 2);
        fib.put(n, ans);
        return ans;
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 15; i++) {
//            System.out.println("fibonacci(" + i + ") = " + fibonacciRec(i));
//        }

        int input = 50;

        Stopwatch timer = Stopwatch.createStarted();
        int ans = fibonacciRec(input);
        System.out.println("fibonacciRec(" + input + ") = " + ans + ", computed in : " + timer.elapsed(TimeUnit.MICROSECONDS) + " + MICROSECONDS");

        timer = Stopwatch.createStarted();
        long ans1 = fibonacciRecMem(input);
        System.out.println("fibonacciRecMem(" + input + ") = " + ans1 + ", computed in : " + timer.elapsed(TimeUnit.MICROSECONDS) + " + MICROSECONDS");
    }
}
