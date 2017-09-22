package com;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * @author: pgajjar
 * @since: 9/18/17
 */
public class MapExamples {
    public static void main(String[] args) {
        final Multimap<Integer, String> employees = ArrayListMultimap.create();

        employees.put(100, "Pradip");
        employees.put(100, "Rakesh");
        employees.put(100, "Aarav");
        employees.put(200, "Aaradhya");
        employees.put(200, "Swara");
        employees.put(200, "Aarya");

        System.out.println("Maps: " + employees);
    }
}
