import java.util.*;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println("GCD: " + GCD(3918848, 16532640));
        System.out.println("GCDRec: " + GCDRec(357, 234));
    }

    public static long GCD(long a, long b) {
        long gcd = 1;
        for (long i = 1; i <= ((a < b) ? a : b); i++) {
            if (a % i ==0 && b % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    public static long GCDRec(long a, long b) {
        return (b == 0) ? a : GCDRec(b, a % b);
    }
}