package com.InterviewCake;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

/**
 * @author: pgajjar
 * @since: 9/1/17
 */
public class Sol3_HighestProductOfThree {
    public static long highestProductOf3(int[] numbers) {
        if (numbers.length < 3) {
            throw new IllegalArgumentException("highestProductOf3 should atleast have 3 elements");
        } else if (numbers.length == 3) {
            return (long) numbers[0] * numbers[1] * numbers[2];
        }

        int lowest1 = 0, lowest2 = 0;
        int highest1 = 0, highest2 = 0, highest3 = 0;

        for (int n : numbers) {
            if (lowest1 > n) {
                lowest2 = lowest1;
                lowest1 = n;
            } else if (lowest2 > n) {
                lowest2 = n;
            } else if (highest1 < n) {
                highest3 = highest2;
                highest2 = highest1;
                highest1 = n;
            } else if (highest2 < n) {
                highest3 = highest2;
                highest2 = n;
            } else if (highest3 < n) {
                highest3 = n;
            }
        }

        long lowestProd = (long) lowest1 * lowest2 * highest1;
        long highestProd = (long) highest1 * highest2 * highest3;

        return (highestProd >= lowestProd) ? highestProd : lowestProd;
    }

    public static long highestProductOf3V1(int[] numbers) {
        if (numbers.length < 3) {
            throw new IllegalArgumentException("highestProductOf3 should atleast have 3 elements");
        }

        long highest = Math.max(numbers[0], numbers[1]);
        long lowest = Math.min(numbers[0], numbers[1]);

        long highestProductOf2 = numbers[0] * numbers[1];
        long lowestProductOf2 = numbers[0] * numbers[1];

        long highestProductOf3 = numbers[0] * numbers[1] * numbers[2];

        for (int i = 2; i < numbers.length; i++) {
            int current = numbers[i];

            highestProductOf3 = Math.max(highestProductOf3, Math.max(highestProductOf2 * current, lowestProductOf2 * current));
            highestProductOf2 = Math.max(highestProductOf2, highest * current);
            lowestProductOf2 = Math.min(lowestProductOf2, lowest * current);

            highest = Math.max(highest, current);
            lowest = Math.min(lowest, current);
        }

        return highestProductOf3;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{-1, -5, 1, 2, 3};
        Stopwatch timer = Stopwatch.createStarted();
        System.out.println(highestProductOf3(numbers) + ", took : " + timer.elapsed(TimeUnit.NANOSECONDS) + " MICROSECONDS");
        timer = Stopwatch.createStarted();
        System.out.println(highestProductOf3V1(numbers) + ", took : " + timer.elapsed(TimeUnit.NANOSECONDS) + " MICROSECONDS");

        numbers = new int[]{-10, -10, 1, 3, 2};
        timer = Stopwatch.createStarted();
        System.out.println(highestProductOf3(numbers) + ", took : " + timer.elapsed(TimeUnit.NANOSECONDS) + " NANOSECONDS");
        timer = Stopwatch.createStarted();
        System.out.println(highestProductOf3V1(numbers) + ", took : " + timer.elapsed(TimeUnit.NANOSECONDS) + " NANOSECONDS");

        numbers = new int[]{-999, -999, 1000000};
        timer = Stopwatch.createStarted();
        System.out.println(highestProductOf3(numbers) + ", took : " + timer.elapsed(TimeUnit.NANOSECONDS) + " NANOSECONDS");
        timer = Stopwatch.createStarted();
        System.out.println(highestProductOf3V1(numbers) + ", took : " + timer.elapsed(TimeUnit.NANOSECONDS) + " NANOSECONDS");


        numbers = new int[]{10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999,
                10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999,
                10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999,
                10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999,
                10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999,
                10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999,
                10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999,
                10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999,
                10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999,
                10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999,
                10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999, 10, 12, 34, -90, -78, 87, 1, 99, 12, 0, 111, 765, 123, 324, -456, 999,
                10, 20, 30, 40, 50, -999, -999, 1000000
        };
        timer = Stopwatch.createStarted();
        System.out.println(highestProductOf3(numbers) + ", took : " + timer.elapsed(TimeUnit.NANOSECONDS) + " NANOSECONDS");
        timer = Stopwatch.createStarted();
        System.out.println(highestProductOf3V1(numbers) + ", took : " + timer.elapsed(TimeUnit.NANOSECONDS) + " NANOSECONDS");

//        numbers = new int[] {-10,10};
//        System.out.println(highestProductOf3(numbers));
    }
}
