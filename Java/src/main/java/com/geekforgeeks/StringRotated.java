package com.geekforgeeks;

import java.util.Scanner;

/**
 * @author : pgajjar
 * @see : http://www.practice.geeksforgeeks.org/problem-page.php?pid=1707
 * @since : 3/20/17
 */
public final class StringRotated {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCasesCount = scanner.nextInt();

        final String original[] = new String[testCasesCount];
        final String rotated[] = new String[testCasesCount];

        for (int i = 0; i < testCasesCount; i++) {
            original[i] = scanner.next();
            rotated[i] = scanner.next();
        }

        for (int i = 0; i < testCasesCount; i++) {
            System.out.println(isRotatedBy2Chars(original[i], rotated[i]) ? 1 : 0);
        }

        // System.out.println("original: " + Arrays.toString(original) + ", rotated: " + Arrays.toString(rotated));
    }

    private static boolean isRotatedBy2Chars(final String original, final String rotated) {
        return (original.substring(0, 1).equals(rotated.substring(rotated.length() - 2, rotated.length() - 1)) && (original.substring(2, original.length() - 1).equals(rotated.substring(0, rotated.length() - 3)))) ||
                (rotated.substring(0, 1).equals(original.substring(original.length() - 2, original.length() - 1)) && (rotated.substring(2, rotated.length() - 1).equals(original.substring(0, original.length() - 3))));

    }
}
