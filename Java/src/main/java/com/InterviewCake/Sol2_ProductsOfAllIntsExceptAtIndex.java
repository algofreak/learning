package com.InterviewCake;

import java.util.Arrays;

/**
 * @author: pgajjar
 * @since: 8/25/17
 */
public class Sol2_ProductsOfAllIntsExceptAtIndex {

    public static long[] getProductsOfAllIntsExceptAtIndexV1(int[] numbers) {
        long[] products = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long product = 1;
            for (int j = 0; j < numbers.length; j++) {
                if (i != j) {
                    product *= numbers[j];
                }
            }
            products[i] = product;
        }

        return products;
    }

    /**
     * [3, 1, 2, 5, 6, 4]
     * first for loop
     * [1, 3,  3 * 1,  3 * 1 * 2,  3 * 1 * 2 * 5,  3 * 1 * 2 * 5 * 6]
     * second for loop
     * [1 * 2 * 5 * 6 * 4,  2 * 5 * 6 * 4,  5 * 6 * 4, 6 * 4, 4 , 1]
     */
    public static long[] getProductsOfAllIntsExceptAtIndex(int[] numbers) {
        long[] products = new long[numbers.length];

        long product = 1;
        for (int i = 0; i < numbers.length; i++) {
            products[i] = product;
            product *= numbers[i];
        }

        product = 1;
        for (int i = (numbers.length - 1); i >= 0; i--) {
            products[i] *= product;
            product *= numbers[i];
        }

        return products;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 7, 3, 4};
//        System.out.println(Arrays.toString(getProductsOfAllIntsExceptAtIndexV1(numbers)));
        System.out.println(Arrays.toString(getProductsOfAllIntsExceptAtIndex(numbers)));

//        numbers = new int[] {3, 1, 2, 5, 6, 4};
//        System.out.println(Arrays.toString(getProductsOfAllIntsExceptAtIndexV1(numbers)));
//        System.out.println(Arrays.toString(getProductsOfAllIntsExceptAtIndex(numbers)));
    }
}
