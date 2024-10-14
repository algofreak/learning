package com.problems.interviewcamp;

import com.google.common.primitives.Ints;
import edu.emory.mathcs.backport.java.util.Collections;

import java.util.List;

/**
 * @author: pgajjar
 */
// Incomplete
public class FindDifferenceElements {
    public static void findDifferenceElementes(List<Integer> elements, int k) {
        Collections.sort(elements);
        System.out.println(elements);
        for(int i = 0; i < elements.size() - k; i++) {
            Integer other = elements.get(i + k);
            if (elements.get(i) + other == k) {
                System.out.println("(" + elements.get(i) + ", " + other + ")");
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 5, 9, 2, 12, 3, 1, 2, 0};
        findDifferenceElementes(Ints.asList(nums), 2);
    }
}
