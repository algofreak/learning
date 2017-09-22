package com.InterviewCake;

import java.util.Arrays;

/**
 * @author: pgajjar
 * @since: 9/6/17
 */
public class Sol5_CoinCombination {
    public static void coinCombinations(long amount, long[] denominations) {
        for (int i = 0; i < denominations.length; i++) {
            coinCombinations(amount, i, denominations, null);
        }
    }

    private static void coinCombinations(long amount, int index, long[] denominations, long[] pattern) {
        if (pattern != null) {
            long sum = Arrays.stream(pattern).sum();
            if (sum == amount) {
                System.out.println(Arrays.toString(pattern));
            }
        } else {
            pattern = new long[denominations.length];
        }


    }

    public static void main(String[] args) {
        coinCombinations(4, new long[]{1, 2, 3});
    }
}
