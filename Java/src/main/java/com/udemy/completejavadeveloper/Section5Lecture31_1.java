package com.udemy.completejavadeveloper;

/**
 * @author: pgajjar
 * @since: 8/12/17
 */
public class Section5Lecture31_1 {

    public static double calcFeetAndInchesToCentimeters(final long feet, final long inches) {
        if (feet >= 0 && (inches >= 0 && inches <= 12)) {
            return ((feet * 12) + inches) * 2.54d;
        }
        return -1;
    }

    public static double calcFeetAndInchesToCentimeters(final long feet) {
        if (feet >= 0) {
            return calcFeetAndInchesToCentimeters(feet / 12, feet % 12);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(calcFeetAndInchesToCentimeters(6, 0) + " cms");
        System.out.println(calcFeetAndInchesToCentimeters(7, 5) + " cms");
        System.out.println(calcFeetAndInchesToCentimeters(6, -10) + " cms");
        System.out.println(calcFeetAndInchesToCentimeters(157   ) + " cms");
    }
}
