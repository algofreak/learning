import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;
import java.lang.Math;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;

        TreeMap<Double, Integer> pool = sortedPool(values, weights);
        for (Double unit : pool.keySet()) {
            if (capacity <= 0) {
                return value;
            }
            Integer index = pool.get(unit);
            int w = Math.min(capacity, weights[index]);
            value += (unit * w);
            capacity -= w;
        }

        return value;
    }

    private static TreeMap<Double, Integer> sortedPool(int[] values, int[] weights) {
        TreeMap<Double, Integer> pool = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < values.length; i++) {
            pool.put((double) values[i] / weights[i], i);
        }
        // System.out.println(pool);
        return pool;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.printf("%.4f\n", getOptimalValue(capacity, values, weights));
        // System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
