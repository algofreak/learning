import java.util.*;

public class CoveringSegments {

    private static List<Integer> optimalPoints(Segment[] segments) {
        // System.out.println("Unsorted: " + Arrays.toString(segments));
        Arrays.sort(segments);
        // System.out.println("Sorted: " + Arrays.toString(segments));

        int j = 0;
        List<Integer> points = new ArrayList<>();
        for (int i = 0; i < segments.length; i++) {
            Segment current = segments[i];
            // System.out.println("current: " + current);
            Segment newCurrent = null;
            while ((i < segments.length - 1) && (newCurrent = Segment.intersection(current, segments[i + 1])) != null) {
                i++;
                current = newCurrent;
                // System.out.println(i + " / " + segments.length + " -> " + current);
            }
            points.add(current.end);
        }
        return points;
    }

    private static class Segment implements Comparable<Segment> {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        Segment(Segment clone) {
            this.start = clone.start;
            this.end = clone.end;
        }

        public int compareTo(Segment other) {
            return this.start - other.start;
        }

        public static boolean overlaps(Segment one, Segment two) {
            return (one.end >= two.start && one.end <= two.end) || (two.end >= one.start && two.end <= one.end) || (one.start == two.start && one.end == two.end);
        }

        public static Segment intersection(Segment one, Segment two) {
            // System.out.println("intersection, one: " + one + " two: " + two);
            if (overlaps(one, two)) {
                return new Segment(Math.max(one.start, two.start), Math.min(one.end, two.end));
            }
            return null;
        }

        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        List<Integer> points = optimalPoints(segments);
        System.out.println(points.size());
        for (Integer point : points) {
            System.out.print(point + " ");
        }
    }
}
 
