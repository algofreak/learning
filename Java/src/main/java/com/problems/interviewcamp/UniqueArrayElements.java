package com.problems.interviewcamp;

import java.util.Arrays;

/**
 * @author: pgajjar
 */
public class UniqueArrayElements {
    public static int removeDuplicates(int[] nums) {
        int curr = 0;
        int next = curr + 1;
        int pos = curr + 1;

        while (next < nums.length) {
            if (nums[curr] != nums[next]) {
                nums[pos] = nums[next];
                curr = next;
                pos++;
            }
            next++;
        }
        Arrays.stream(nums).limit(pos).forEach(System.out::println);

        return pos;
    }

    public static void main(String[] args) {
        removeDuplicates(new int[]{1, 1, 2});
        removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }
}
