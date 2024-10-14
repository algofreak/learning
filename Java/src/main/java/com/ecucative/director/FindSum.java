package com.ecucative.director;

/**
 * @author: pgajjar
 */
public class FindSum {
    public static void main(String[] args) {
        final int[] numbers = { 2, 3, 5, 7, 11, 12, 13 };
        final int sum = 14;

        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            final int actualSum = numbers[i] + numbers[j];
            if (actualSum == sum) {
                System.out.printf("Expected Sum %d is at indexes, numbers[%d]=%d and numbers[%d]=%d.\n", sum, i, numbers[i], j, numbers[j]);
                i++;
                j--;
            } else if (actualSum < sum) {
                i++;
            } else if (actualSum > sum) {
                j--;
            }
        }
    }
}
