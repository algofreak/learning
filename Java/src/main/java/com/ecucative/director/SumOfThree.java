package com.ecucative.director;

import java.util.Arrays;

/**
 * @author: pgajjar
 */
public class SumOfThree {
    public static boolean findSumOfThree(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            int first = nums[i];

            int j = i + 1;
            int k = len - 1;
            int expectedSumOfOtherTwo = target - first;

            while (j < k) {
                int sumOfOtherTwo = nums[j] + nums[k];

                if (sumOfOtherTwo == expectedSumOfOtherTwo) {
                    System.out.printf("Expected sum: %d found: nums[%d]=%d, nums[%d]=%d and nums[%d]=%d.\n",
                            target, i, nums[i], j, nums[j], k, nums[k]);
                    // not needed but doing it for a sanity
                    j++;
                    k--;
                    return true;
                } else if (sumOfOtherTwo < expectedSumOfOtherTwo) {
                    j++;
                } else if (sumOfOtherTwo > expectedSumOfOtherTwo) {
                    k--;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6, 8, 28};
        int target = 31;
        
        System.out.println(findSumOfThree(nums, target));
    }
}
