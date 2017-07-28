import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int change = 0;
        while (m > 0) {
            if (m > 10) {
                change += (m / 10);
                m %= 10;
            } else if (m > 5) {
                change += (m / 5);
                m %= 5;
            } else {
                change += m;
                m %= 1;
            }
        }
        return change;
    }

    // recursive greedy approach
    private static int getChangeRec(int m) {
        if (m <= 0) return 0;
        int div = (m > 10) ? 10 : ((m > 5) ? 5 : 1);
        return (m / div) + getChangeRec(m % div);
    }

    private static int getChange(int capacity, int[] values) {
        int change = 0;
        for (int i = 0; i < values.length; i++) {
            change += capacity / values[i];
            capacity %= values[i];
        }
        return change;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m, new int[] {10, 5, 1}));
        // System.out.println(getChangeRec(m));
    }
}

