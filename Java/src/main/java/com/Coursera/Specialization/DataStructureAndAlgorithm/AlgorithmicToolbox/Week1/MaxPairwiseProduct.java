import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProductSlow(int[] numbers) {
        long result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (numbers[i] * numbers[j] > result) {
                    result = (long) numbers[i] * numbers[j];
                }
            }
        }
        return result;
    }

    static long getMaxPairwiseProduct(int[] numbers) {
        long highest = 0;
        long secondHighest = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > highest) {
                secondHighest = highest;
                highest = numbers[i];
            } else if (numbers[i] > secondHighest) {
                secondHighest = numbers[i];
            }
        }

        return highest * secondHighest;
    }

    public static void main(String[] args) {
        /*
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
        */

        while(true) {
            int[] numbers = new Random().ints(100, 0, 10000).toArray();
            System.out.println(Arrays.toString(numbers));

            long slow = getMaxPairwiseProductSlow(numbers);
            long fast = getMaxPairwiseProduct(numbers);

            if (slow != fast) {
                System.out.println("Wrong answer slow: " + slow + ", fast: " + fast);
            } else {
                System.out.println("OK");
            }
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
