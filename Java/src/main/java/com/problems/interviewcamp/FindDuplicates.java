package com.problems.interviewcamp;

import com.google.common.primitives.Ints;

import java.util.Collections;
import java.util.List;

/**
 * @author: pgajjar
 */
public class FindDuplicates {
    public static int findDuplicate(int[] numbers) {
        int dup = -1;
        final List<Integer> integers = Ints.asList(numbers);
        Collections.sort(integers);
        System.out.println(integers);
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) == integers.get(i + 1)) {
                return integers.get(i);
            }
        }
        return dup;
    }

    public static void main(String[] args) {
        int[] nums = {7, 5, 2, 3, 1, 2, 0};
        int duplicate = findDuplicate(nums);
        System.out.println("Duplicate num: " + duplicate);
    }
}
