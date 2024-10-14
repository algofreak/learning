package com.geekforgeeks.dsa;

/**
 * @author: pgajjar
 */
public class DigitsFinder {
    public static int find(int num){
        int count = 0;
        while(num != 0) {
            count++;
            num /= 10;
        }
        return count;
    }

    public static int findRec(int num) {
        if (num == 0) {
            return 0;
        }
        return 1 + findRec(num / 10);
    }
    
    public static int findLog(int num) {
        return (int) Math.floor(Math.log10(num) + 1);
    }

    public static void main(String[] args) {
        System.out.println(find(1));
        System.out.println(findRec(1234));
        System.out.println(findLog(1));
    }
}
